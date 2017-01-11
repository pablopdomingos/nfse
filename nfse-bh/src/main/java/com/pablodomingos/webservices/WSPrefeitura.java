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

public class WSPrefeitura {

  public static String consultaSituacaoLoteRps(String xml, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).consultarSituacaoLoteRps(geraParametros(xml)).getOutputXML();
  }

  public static String consultaRps(String xml, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).consultarNfsePorRps(geraParametros(xml)).getOutputXML();
  }

  public static String enviaRps(String loteRpsAssinado, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).gerarNfse(geraParametros(loteRpsAssinado)).getOutputXML();
  }

  public static String enviaLoteRps(String loteRpsAssinado, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).recepcionarLoteRps(geraParametros(loteRpsAssinado)).getOutputXML();
  }
  
  public static String consultaNFSe(String xml, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).consultarNfse(geraParametros(xml)).getOutputXML();
  }
  
  public static String consultaLote(String xml, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).consultarLoteRps(geraParametros(xml)).getOutputXML();
  }
  
  public static String cancelaNFSe(String xml, CertificadoConfig configCertificado)
      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
      IOException {

    return webService(configCertificado).cancelarNfse(geraParametros(xml)).getOutputXML();
  }
  
  private static Input geraParametros(String xml){
    
    Input parametro = new Input();
    parametro.setNfseCabecMsg(XmlUtil.getCabecMsg());

    parametro.setNfseDadosMsg(xml);
    return parametro;
    
  }
  
  private static Nfse webService(CertificadoConfig configCertificado) throws ServiceException{
    configCertificado.carregarCertificados();

    NfseWSService _service = new NfseWSServiceLocator(configCertificado.getAmbiente());
    
    return _service.getnfseSOAP();
  }
}
