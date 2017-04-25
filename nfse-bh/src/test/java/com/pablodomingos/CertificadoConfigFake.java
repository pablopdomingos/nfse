package com.pablodomingos;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.config.CertificadoConfig;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class CertificadoConfigFake extends CertificadoConfig {
  private KeyStore keyStoreCertificado;
  private KeyStore keyStoreCadeia;

  @Override
  public String getCertificadoSenha() {
    String senha = "";
    try (FileInputStream inputStream = new FileInputStream("password")) {
      senha = IOUtils.toString(inputStream);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return senha;
  }

  @Override
  public String getCadeiaCertificadosSenha() {
    return "senha";
  }

  @Override
  public String getAliasCertificado() {
    return null;
  }

  @Override
  public NFSeAmbiente getAmbiente() {
    return NFSeAmbiente.HOMOLOGACAO;
  }

  @Override
  public KeyStore getCertificadoKeyStore() throws KeyStoreException {
    if (this.keyStoreCertificado == null) {
      this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
      try (InputStream certificadoStream = new FileInputStream("certificado.pfx")) {
        this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
      } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
        this.keyStoreCadeia = null;
        throw new KeyStoreException("Certificado inválido", e);
      }
    }
    return this.keyStoreCertificado;
  }

  @Override
  public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
    if (this.keyStoreCadeia == null) {
      this.keyStoreCadeia = KeyStore.getInstance("JKS");
      try (InputStream cadeia = new FileInputStream("nfse-bh.cacerts")) {
        this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
      } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
        this.keyStoreCadeia = null;
        throw new KeyStoreException("Cadeia de certificados inválida", e);
      }
    }
    return this.keyStoreCadeia;
  }
}
