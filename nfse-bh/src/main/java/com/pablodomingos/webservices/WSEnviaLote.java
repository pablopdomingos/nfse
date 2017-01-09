package com.pablodomingos.webservices;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;

import javax.xml.rpc.ServiceException;

import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.webservices.pbh.Input;
import com.pablodomingos.webservices.pbh.Nfse;
import com.pablodomingos.webservices.pbh.NfseWSService;
import com.pablodomingos.webservices.pbh.NfseWSServiceLocator;

public class WSEnviaLote {
  
  private static String CabecMsg = "<?xml version='1.0' encoding='UTF-8'?>"
      + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
      + "<versaoDados>1.00</versaoDados>"
      + "</cabecalho>";
  
  
  @SuppressWarnings("restriction")
  public static String enviarLote(String rpsAssinado, CertificadoConfig configCertificado) throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
    
    System.clearProperty("javax.net.ssl.keyStore");  
    System.clearProperty("javax.net.ssl.keyStorePassword");  
    System.clearProperty("javax.net.ssl.trustStore");  
    
    if(configCertificado.getTipoCertificado().equals(TipoCertificado.A1)){
      
      System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  

      System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
      System.setProperty("javax.net.ssl.keyStore", configCertificado.getCaminhoParaCertificado());  
      System.setProperty("javax.net.ssl.keyStorePassword", configCertificado.getSenhaCertificado());  
      
    }else if(configCertificado.getTipoCertificado().equals(TipoCertificado.A3_CARD)){
      
      System.setProperty("javax.net.ssl.keyStore", "NONE");  
      System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");  
      System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-SmartCard"); 
      
    }else if(configCertificado.getTipoCertificado().equals(TipoCertificado.A3_TOKEN)){
      
      System.setProperty("javax.net.ssl.keyStore", "NONE");  
      System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");  
      System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-eToken"); 
      
    }
    
    System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
    System.setProperty("javax.net.ssl.trustStore", configCertificado.getCaminhoParaCadeiaCertificado());  
    
    NfseWSService _service = new NfseWSServiceLocator(configCertificado.getAmbiente());
    Nfse nfse = _service.getnfseSOAP();
    
    Input parametro = new Input();
    parametro.setNfseCabecMsg(CabecMsg);
    
    parametro.setNfseDadosMsg(rpsAssinado);
    
    return nfse.gerarNfse(parametro).getOutputXML();
  }
  
}
