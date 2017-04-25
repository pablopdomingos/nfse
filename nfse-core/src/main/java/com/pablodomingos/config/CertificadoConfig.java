package com.pablodomingos.config;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;


public abstract class CertificadoConfig {

  public abstract String getCertificadoSenha();

  public abstract String getCadeiaCertificadosSenha();

  public abstract String getAliasCertificado();

  public abstract NFSeAmbiente getAmbiente();

  public abstract KeyStore getCertificadoKeyStore() throws KeyStoreException;

  public abstract KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException;

  public void carregarCertificados() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, IOException, CertificateException {
    KeyStore keyStoreCertificado = getCertificadoKeyStore();
    KeyStore keyStoreCadeiaDeCertificados = getCadeiaCertificadosKeyStore();
    char[] keyPassword = getCertificadoSenha().toCharArray();

    // initialize a trust manager factory with the trusted store
    KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    keyFactory.init(keyStoreCertificado, keyPassword);

    // get the trust managers from the factory
    KeyManager[] keyManagers = keyFactory.getKeyManagers();

    // Now get trustStore
//    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

    // if your store is password protected then declare it (it can be null however)
    //char[] trustPassword = password.toCharArray();

    // load the stream to your store
//    trustStore.load(cadeiaCertificado, null);

    // initialize a trust manager factory with the trusted store
    TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustFactory.init(keyStoreCadeiaDeCertificados);

    // get the trust managers from the factory
    TrustManager[] trustManagers = trustFactory.getTrustManagers();

    // initialize an ssl context to use these managers and set as default
    SSLContext sslContext = SSLContext.getInstance("SSL");
    sslContext.init(keyManagers, trustManagers, null);
    SSLContext.setDefault(sslContext);

//    System.clearProperty("javax.net.ssl.keyStore");
//    System.clearProperty("javax.net.ssl.keyStorePassword");
//    System.clearProperty("javax.net.ssl.trustStore");
//
//    if (this.getTipoCertificado().equals(TipoCertificado.A1)) {
//
//      System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
//      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//      System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//      System.setProperty("javax.net.ssl.keyStore", this.getCaminhoParaCertificado());
//      System.setProperty("javax.net.ssl.keyStorePassword", this.getSenhaCertificado());
//
//    } else if (this.getTipoCertificado().equals(TipoCertificado.A3_CARD)) {
//
//      System.setProperty("javax.net.ssl.keyStore", "NONE");
//      System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");
//      System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-SmartCard");
//
//    } else if (this.getTipoCertificado().equals(TipoCertificado.A3_TOKEN)) {
//
//      System.setProperty("javax.net.ssl.keyStore", "NONE");
//      System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");
//      System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-eToken");
//
//    }
//
//    System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//    System.setProperty("javax.net.ssl.trustStore", this.getCaminhoParaCadeiaCertificado());
  }

}
