package com.pablodomingos.assinatura;

import com.pablodomingos.config.CertificadoConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AssinaturaDigital {
  private CertificadoConfig config;
  protected abstract String informacaoRps();
  protected abstract String[] elementosAssinaveis();

  public AssinaturaDigital(CertificadoConfig config) {
    this.config = config;
  }

  public String assinarXML(String xml) throws Exception {
    String certificateAlias = config.getAliasCertificado() != null ? config.getAliasCertificado()
        : config.getCertificadoKeyStore().aliases().nextElement();
    KeyStore.PasswordProtection passwordProtection =
        new KeyStore.PasswordProtection(this.config.getSenhaCertificado().toCharArray());
    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) config.getCertificadoKeyStore()
        .getEntry(certificateAlias, passwordProtection);

    XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
    ArrayList<Transform> transformList = signatureFactory(signatureFactory);

    X509Certificate cert = (X509Certificate) pkEntry.getCertificate();

    KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
    List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
    x509Content.add(cert);
    X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
    KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

    Document document = documentFactory(xml);

    //Assinando todos RPS
    NodeList elements = document.getElementsByTagName(informacaoRps());
    for (int i = 0; i < elements.getLength(); i++) {
      Element element = (Element) elements.item(i);
      
      String id = element.getAttribute("Id");
      element.setIdAttribute("Id", true);

      Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
      SignedInfo signedInfo = signatureFactory.newSignedInfo( signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
              (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
          Collections.singletonList(reference));

      XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
      signature.sign(new DOMSignContext(pkEntry.getPrivateKey(), element.getParentNode()));
    }
 
    Document documentAssinado = documentFactory(converteDocParaXml(document));
    
    //Assinando o Lote de RPS
    for (final String elementoAssinavel : elementosAssinaveis()) {
      NodeList elementsAssinado = documentAssinado.getDocumentElement().getElementsByTagName(elementoAssinavel);
      for (int i = 0; i < elementsAssinado.getLength(); i++) {
        Element element = (Element) elementsAssinado.item(i);
        
        String id = element.getAttribute("Id");
        element.setIdAttribute("Id", true);

        Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo signedInfo = signatureFactory.newSignedInfo( signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
            Collections.singletonList(reference));

        XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
        signature.sign(new DOMSignContext(pkEntry.getPrivateKey(), element.getParentNode()));
      }
    }
    
    
    return converteDocParaXml(documentAssinado);
  }

  private Document documentFactory(String xml)
      throws SAXException, IOException, ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    Document document =
        factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
    return document;
  }

  private ArrayList<Transform> signatureFactory(XMLSignatureFactory signatureFactory)
      throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
    ArrayList<Transform> transformList = new ArrayList<Transform>();
    TransformParameterSpec tps = null;
    Transform envelopedTransform = signatureFactory.newTransform(Transform.ENVELOPED, tps);
    Transform c14NTransform =
        signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

    transformList.add(envelopedTransform);
    transformList.add(c14NTransform);
    return transformList;
  }
  
  private String converteDocParaXml(Document doc) throws TransformerException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Transformer trans = TransformerFactory.newInstance().newTransformer();
    trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    trans.transform(new DOMSource(doc), new StreamResult(os));
    return os.toString();
}
}
