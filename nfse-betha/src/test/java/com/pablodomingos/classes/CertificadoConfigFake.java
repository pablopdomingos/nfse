package com.pablodomingos.classes;

import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.webservices.betha.WebServiceBethaTest;
import com.pablodomingos.config.CertificadoConfig;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CertificadoConfigFake {
  private static CertificadoConfig certificadoConfig;

  public static CertificadoConfig get() {
    if (certificadoConfig == null) {
      String senha = "";
      try (FileInputStream inputStream = new FileInputStream("password")) {
        senha = IOUtils.toString(inputStream);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      certificadoConfig = new CertificadoConfig(
          new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, senha)
              .comCaminhoCertificadoCliente("/tmp/certificado.pfx")
              .comCaminhoCadeiaDeCertificados(WebServiceBethaTest.class.getClassLoader().getResource("nfse-betha.cacerts").getPath())
              .comAmbiente(NFSeAmbiente.HOMOLOGACAO));
    }
    return certificadoConfig;
  }
}
