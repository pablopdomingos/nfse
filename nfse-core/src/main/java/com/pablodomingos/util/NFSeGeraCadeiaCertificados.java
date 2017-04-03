package com.pablodomingos.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class NFSeGeraCadeiaCertificados {
  private static final int PORT = 443;
  private static final Logger LOGGER = Logger.getLogger("NFSeGeraCadeiaCertificados");
  
  public static byte[] geraCadeiaCertificados(String senha) throws Exception {
    
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());  
    ks.load(null, senha.toCharArray());   
      
    get("bhisshomologa.pbh.gov.br", PORT, ks); 
    get("bhissdigital.pbh.gov.br", PORT, ks); 
    
    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    ks.store(out, senha.toCharArray());
    
    return out.toByteArray();
  }

  public static void get(String host, int port, KeyStore keyStore) throws Exception {
    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(keyStore);
    
    X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
    SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
    
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, new TrustManager[] {tm}, null);
    
    LOGGER.info("Iniciando conexão com: " + host + ":" + port + "...");
    SSLSocket socket = (SSLSocket) sslContext.getSocketFactory().createSocket(host, port);
    
    try {
      socket.setSoTimeout(30 * 1000);
      socket.startHandshake();
      socket.close();
    } catch (Exception e) {
      LOGGER.info(e.toString());
    } 

    X509Certificate[] chain = tm.chain;
    if (chain == null) {
      LOGGER.info("Não foi possivel obter a cadeia de certificados");
    }

    LOGGER.info("O servidor enviou " + chain.length + " certificado(s):");
    MessageDigest sha1 = MessageDigest.getInstance("SHA1");
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    for (int i = 0; i < chain.length; i++) {
      X509Certificate cert = chain[i];
      sha1.update(cert.getEncoded());
      md5.update(cert.getEncoded());

      String alias = host + "-" + (i);
      keyStore.setCertificateEntry(alias, cert);
      LOGGER.info("Certificado adicionado usando alias: '" + alias + "'");
    }
  }

  private static class SavingTrustManager implements X509TrustManager {
    private final X509TrustManager tm;
    private X509Certificate[] chain;

    SavingTrustManager(X509TrustManager tm) {
      this.tm = tm;
    }

    public X509Certificate[] getAcceptedIssuers() {
      throw new UnsupportedOperationException();
    }

    public void checkClientTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {
      throw new UnsupportedOperationException();
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {
      this.chain = chain;
      tm.checkServerTrusted(chain, authType);
    }
  }

}
