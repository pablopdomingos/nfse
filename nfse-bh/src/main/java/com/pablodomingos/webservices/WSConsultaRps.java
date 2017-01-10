package com.pablodomingos.webservices;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.rpc.ServiceException;

import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.util.XmlUtil;
import com.pablodomingos.webservices.pbh.Input;
import com.pablodomingos.webservices.pbh.Nfse;
import com.pablodomingos.webservices.pbh.NfseWSService;
import com.pablodomingos.webservices.pbh.NfseWSServiceLocator;

public class WSConsultaRps {
  
  
  
  
  public static String consultarRps(String xml, CertificadoConfig configCertificado) throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
    
    configCertificado.carregarCertificados();  
    
    NfseWSService _service = new NfseWSServiceLocator(configCertificado.getAmbiente());
    Nfse nfse = _service.getnfseSOAP();
    
    Input parametro = new Input();
    parametro.setNfseCabecMsg(XmlUtil.getCabecMsg());
    
    parametro.setNfseDadosMsg(xml);
    
    return nfse.consultarNfsePorRps(parametro).getOutputXML();
  }
  
}
