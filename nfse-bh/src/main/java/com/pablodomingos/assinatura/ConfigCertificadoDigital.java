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


public class ConfigCertificadoDigital {

  public TipoCertificado tipoCertificado;

  public String senhaCertificado;

  public String aliasCertificado;

  public String caminhoParaCertificado;

  private KeyStore keyStoreCertificado;

  public ConfigCertificadoDigital(ConfigCertificadoDigitalBuilder builder) {
    super();
    this.senhaCertificado = builder.senhaCertificado;
    this.aliasCertificado = builder.aliasCertificado;
    this.tipoCertificado = builder.tipoCertificado;
    this.caminhoParaCertificado = builder.caminhoParaCertificado;
  }

  public KeyStore getCertificadoKeyStore() throws KeyStoreException {
    try {
      if (keyStoreCertificado == null) {

        if (tipoCertificado.equals(TipoCertificado.A3_TOKEN)) {

          InputStream input = getClass().getClassLoader().getResourceAsStream("Token.cfg");
          @SuppressWarnings("restriction")
          Provider provider = new sun.security.pkcs11.SunPKCS11(input);
          Security.addProvider(provider);

          this.keyStoreCertificado = KeyStore.getInstance("pkcs11", provider);
          try {
            this.keyStoreCertificado.load(null, this.senhaCertificado.toCharArray());
          } catch (IOException e) {
            throw new KeyStoreException(
                "Senha do Certificado Digital incorreta ou Certificado inválido.");
          }
        } else if (tipoCertificado.equals(TipoCertificado.A3_CARD)) {

          InputStream input = getClass().getClassLoader().getResourceAsStream("SmartCard.cfg");
          @SuppressWarnings("restriction")
          Provider provider = new sun.security.pkcs11.SunPKCS11(input);
          Security.addProvider(provider);

          this.keyStoreCertificado = KeyStore.getInstance("pkcs11", provider);
          try {
            this.keyStoreCertificado.load(null, this.senhaCertificado.toCharArray());
          } catch (IOException e) {
            throw new KeyStoreException(
                "Senha do Certificado Digital incorreta ou Certificado inválido.");
          }
        } else if (tipoCertificado.equals(TipoCertificado.A1)) {

          InputStream certificadoStream = new FileInputStream(caminhoParaCertificado);
          this.keyStoreCertificado = KeyStore.getInstance("pkcs12");
          try {
            this.keyStoreCertificado.load(certificadoStream,
                this.getCertificadoSenha().toCharArray());
          } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new KeyStoreException(
                "Senha do Certificado Digital incorreta ou Certificado inválido.", e);
          }
        }
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

  public static class ConfigCertificadoDigitalBuilder {

    public TipoCertificado tipoCertificado = null;
    public String senhaCertificado = null;
    public String aliasCertificado = null;
    public String caminhoParaCertificado = "/certificado/certificado.pfx";

    public ConfigCertificadoDigitalBuilder(TipoCertificado tipoCertificado,
        String senhaCertificado) {

      if (tipoCertificado == null || senhaCertificado == null) {
        throw new IllegalArgumentException("senha ou tipoCertificado não podem ser null");
      }
      this.tipoCertificado = tipoCertificado;
      this.senhaCertificado = senhaCertificado;
    }

    public ConfigCertificadoDigitalBuilder comAlias(String aliasCertificado) {
      this.aliasCertificado = aliasCertificado;
      return this;
    }

    public ConfigCertificadoDigitalBuilder comCaminhoParaOCertificado(
        String caminhoParaCertificado) {
      this.caminhoParaCertificado = caminhoParaCertificado;
      return this;
    }

    public ConfigCertificadoDigital build() {
      return new ConfigCertificadoDigital(this);
    }

  }
}
