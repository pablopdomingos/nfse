package com.pablodomingos.assinatura;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;


public class CertificadoConfig {

  private TipoCertificado tipoCertificado;
  private String senhaCertificado;
  private String aliasCertificado;
  private String caminhoParaCertificado;
  private String caminhoParaCadeiaCertificado;
  private KeyStore keyStoreCertificado;
  private NFSeAmbiente ambiente;
  
  public CertificadoConfig(CertificadoConfigBuilder builder) {
    super();
    this.senhaCertificado = builder.senhaCertificado;
    this.aliasCertificado = builder.aliasCertificado;
    this.tipoCertificado = builder.tipoCertificado;
    this.caminhoParaCertificado = builder.caminhoParaCertificado;
    this.caminhoParaCadeiaCertificado = builder.caminhoParaCadeiaCertificado;
    this.ambiente = builder.ambiente;
    
  }

  public KeyStore getCertificadoKeyStore() throws KeyStoreException {
    try {
      if (keyStoreCertificado == null) {
        InputStream certificadoStream = null;

        if (tipoCertificado.equals(TipoCertificado.A3_TOKEN)) {

          InputStream inputFile = getClass().getClassLoader().getResourceAsStream("Token.cfg");
          @SuppressWarnings("restriction")
          Provider provider = new sun.security.pkcs11.SunPKCS11(inputFile);
          Security.addProvider(provider);
          this.keyStoreCertificado = KeyStore.getInstance("pkcs11", provider);

        } else if (tipoCertificado.equals(TipoCertificado.A3_CARD)) {

          InputStream inputFile = getClass().getClassLoader().getResourceAsStream("SmartCard.cfg");
          @SuppressWarnings("restriction")
          Provider provider = new sun.security.pkcs11.SunPKCS11(inputFile);
          Security.addProvider(provider);
          this.keyStoreCertificado = KeyStore.getInstance("pkcs11", provider);

        } else if (tipoCertificado.equals(TipoCertificado.A1)) {

          certificadoStream = new FileInputStream(caminhoParaCertificado);
          this.keyStoreCertificado = KeyStore.getInstance("pkcs12");

        }

        this.keyStoreCertificado.load(certificadoStream, this.getSenhaCertificado().toCharArray());

      }

      return this.keyStoreCertificado;

    } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
      throw new KeyStoreException("Ocorreu um erro ao montar a KeyStore com o certificado", e);
    }
  }

  public TipoCertificado getTipoCertificado() {
    return tipoCertificado;
  }

  public String getSenhaCertificado() {
    return senhaCertificado;
  }

  public String getAliasCertificado() {
    return aliasCertificado;
  }

  public String getCaminhoParaCertificado() {
    return caminhoParaCertificado;
  }
  
  public String getCaminhoParaCadeiaCertificado() {
    return caminhoParaCadeiaCertificado;
  }

  public KeyStore getKeyStoreCertificado() {
    return keyStoreCertificado;
  }

  public NFSeAmbiente getAmbiente() {
    return ambiente;
  }

  public static class CertificadoConfigBuilder {

    private TipoCertificado tipoCertificado;
    private String senhaCertificado;
    private String aliasCertificado = null;
    private String caminhoParaCertificado = Paths.get("/certificado/certificado.pfx").toAbsolutePath().toString();
    private String caminhoParaCadeiaCertificado = Paths.get("/certificado/nfse-bh.cacerts").toAbsolutePath().toString();
    private NFSeAmbiente ambiente = NFSeAmbiente.HOMOLOGACAO; 

    public CertificadoConfigBuilder(TipoCertificado tipoCertificado, String senhaCertificado) {

      if (tipoCertificado == null || senhaCertificado == null) {
        throw new IllegalArgumentException("senha ou tipoCertificado não podem ser null");
      }
      this.tipoCertificado = tipoCertificado;
      this.senhaCertificado = senhaCertificado;
    }

    public CertificadoConfigBuilder comAlias(String aliasCertificado) {
      this.aliasCertificado = aliasCertificado;
      return this;
    }

    public CertificadoConfigBuilder comCaminhoCertificadoCliente(String caminhoParaCertificado) {
      this.caminhoParaCertificado = caminhoParaCertificado;
      return this;
    }

    public CertificadoConfigBuilder comCaminhoCadeiaDeCertificados(String caminhoParaCadeiaCertificado) {
      this.caminhoParaCadeiaCertificado = caminhoParaCadeiaCertificado;
      return this;
    }
    
    public CertificadoConfigBuilder comAmbiente(NFSeAmbiente ambiente) {
      this.ambiente = ambiente;
      return this;
    }
    
    public CertificadoConfig build() {
      return new CertificadoConfig(this);
    }

  }
}
