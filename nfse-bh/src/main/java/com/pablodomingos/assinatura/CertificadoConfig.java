package com.pablodomingos.assinatura;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;


public class CertificadoConfig {

  private TipoCertificado tipoCertificado;
  private String senhaCertificado;
  private String aliasCertificado;
  private String caminhoParaCertificado;
  private KeyStore keyStoreCertificado;

  public CertificadoConfig(CertificadoConfigBuilder builder) {
    super();
    this.senhaCertificado = builder.senhaCertificado;
    this.aliasCertificado = builder.aliasCertificado;
    this.tipoCertificado = builder.tipoCertificado;
    this.caminhoParaCertificado = builder.caminhoParaCertificado;
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

        this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());

      }

      return this.keyStoreCertificado;

    } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
      throw new KeyStoreException("Ocorreu um erro ao montar a KeyStore com o certificado", e);
    }
  }

  public String getCertificadoAlias() {
    return this.aliasCertificado;
  }

  public String getCertificadoSenha() {
    return this.senhaCertificado;
  }

  public static class CertificadoConfigBuilder {

    public TipoCertificado tipoCertificado;
    public String senhaCertificado;
    public String aliasCertificado = null;
    public String caminhoParaCertificado = "/certificado/certificado.pfx";

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

    public CertificadoConfigBuilder comCaminhoParaOCertificado(String caminhoParaCertificado) {
      this.caminhoParaCertificado = caminhoParaCertificado;
      return this;
    }

    public CertificadoConfig build() {
      return new CertificadoConfig(this);
    }

  }
}
