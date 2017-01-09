package com.pablodomingos.webservices;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;

import javax.xml.rpc.ServiceException;

import com.pablodomingos.App;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.webservices.pbh.Input;
import com.pablodomingos.webservices.pbh.Nfse;
import com.pablodomingos.webservices.pbh.NfseWSService;
import com.pablodomingos.webservices.pbh.NfseWSServiceLocator;

public class WSEnviaLote {
  
  private static String CabecMsg = "<?xml version='1.0' encoding='UTF-8'?>"
      + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
      + "<versaoDados>1.00</versaoDados>"
      + "</cabecalho>";
  
  
  public static String enviarLote(String rpsAssinado, NFSeAmbiente ambiente) throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
    InputStream inputFile = WSEnviaLote.class.getClassLoader().getResourceAsStream("Token.cfg");
    Provider p = new sun.security.pkcs11.SunPKCS11(inputFile);  
    Security.addProvider(p);  
    char[] pin = "senha".toCharArray();  
    KeyStore ks = KeyStore.getInstance("pkcs11", p);  
    ks.load(null, pin);  
    
    String arquivoCacertsGeradoTodosOsEstados = WSEnviaLote.class.getClassLoader().getResource("nfse-bh.cacerts").getPath();
    System.out.println(arquivoCacertsGeradoTodosOsEstados);
    System.setProperty("javax.net.ssl.keyStore", "NONE");  
    System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");  
    System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-eToken");  
    System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
    System.setProperty("javax.net.ssl.trustStore", arquivoCacertsGeradoTodosOsEstados); 
    
    NfseWSService _service = new NfseWSServiceLocator(ambiente);
    Nfse nfse = _service.getnfseSOAP();
    
    Input parametro = new Input();
    parametro.setNfseCabecMsg(CabecMsg);
    
    parametro.setNfseDadosMsg(rpsAssinado);
    
    return nfse.gerarNfse(parametro).getOutputXML();
  }
  
}
