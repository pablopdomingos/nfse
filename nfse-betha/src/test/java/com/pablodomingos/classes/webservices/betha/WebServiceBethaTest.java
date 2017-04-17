package com.pablodomingos.classes.webservices.betha;

import com.pablodomingos.assinatura.AssinaturaDigitalBetha;
import com.pablodomingos.classes.CertificadoConfigFake;
import com.pablodomingos.classes.FabricaDeBuildersFake;
import com.pablodomingos.classes.XmlFake;
import com.pablodomingos.classes.respostas.*;
import com.pablodomingos.classes.rps.LoteRpsBetha;
import com.pablodomingos.classes.servicos.LoteRpsEnvioBetha;
import com.pablodomingos.utils.NFSeGeraCadeiaCertificadosBetha;
import com.pablodomingos.webservices.betha.WebServiceBetha;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.security.SecureRandom;

public class WebServiceBethaTest {
  public static SecureRandom random = new SecureRandom();

  @Test
  public void gerarCacerts() {
    try {
      FileUtils.writeByteArrayToFile(new File("nfse-betha.cacerts"), NFSeGeraCadeiaCertificadosBetha.geraCadeiaCertificados("senha"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testaGerarNfse() {
    GerarNfseRespostaBetha gerarNfseRespostaBetha = null;
    String xml = XmlFake.get("gerarNfse.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    int numero = random.nextInt(Integer.MAX_VALUE);
    try {
      xml = xml.replace("{NUMERO}", String.valueOf(numero));
      AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
      xml = assinatura.assinarXML(xml);
      gerarNfseRespostaBetha = WebServiceBetha.gerarNfse(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(gerarNfseRespostaBetha.getListaNfse().get(0).getNfse().getInfNfse().getPrestadorServico().getEndereco().getEndereco(), "Ambiente de testes não requer endereço");
  }

  @Test
  public void testaRecepcionarLoteRps() {
    EnviarLoteRpsRespostaBetha enviarLoteRpsRespostaBetha = null;
    String xml = XmlFake.get("recepcionarLoteRps.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    int lote = random.nextInt(Integer.MAX_VALUE);
    int numero = random.nextInt(Integer.MAX_VALUE);
    try {
      xml = xml.replace("{LOTE}", String.valueOf(lote));
      xml = xml.replace("{NUMERO}", String.valueOf(numero));
      AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
      xml = assinatura.assinarXML(xml);
      enviarLoteRpsRespostaBetha = WebServiceBetha.enviarLoteRps(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertNotNull(enviarLoteRpsRespostaBetha);
  }

  @Test
  public void testaCancelarNfse() {
    CancelarNfseRespostaBetha cancelarNfseRespostaBetha = null;
    String xml = XmlFake.get("cancelarNfse.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    try {
      AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
      xml = assinatura.assinarXML(xml);
      cancelarNfseRespostaBetha = WebServiceBetha.cancelarNfse(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertNotNull(cancelarNfseRespostaBetha);
  }

  @Test
  public void testaGeracaoLote() {
    EnviarLoteRpsRespostaBetha enviarLoteRpsRespostaBetha = null;
    LoteRpsBetha loteRpsBetha = new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
    LoteRpsEnvioBetha loteRpsEnvio = new LoteRpsEnvioBetha(loteRpsBetha);
    String xml = loteRpsEnvio.converterParaXml();
    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
    try {
      xml = assinatura.assinarXML(xml);
      enviarLoteRpsRespostaBetha = WebServiceBetha.enviarLoteRps(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(enviarLoteRpsRespostaBetha.getNumeroLote(), loteRpsBetha.getNumeroLote());
  }

  @Test
  public void testaConsultaNfseServicoPrestado() {
    ConsultarNfseServicoPrestadoRespostaBetha consultarNfseServicoPrestadoRespostaBetha = null;
    String xml = XmlFake.get("consultarNfseServicoPrestado.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    try {
      consultarNfseServicoPrestadoRespostaBetha = WebServiceBetha.consultarNfseServicoPrestado(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertNotNull(consultarNfseServicoPrestadoRespostaBetha);
  }

  @Test
  public void testaConsultaNfseServicoTomado() {
    ConsultarNfseServicoTomadoRespostaBetha consultarNfseServicoTomadoRespostaBetha = null;
    String xml = XmlFake.get("consultarNfseServicoTomado.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    try {
      consultarNfseServicoTomadoRespostaBetha = WebServiceBetha.consultarNfseServicoTomado(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertNotNull(consultarNfseServicoTomadoRespostaBetha);
  }

  @Test
  public void testaConsultaLoteRps() {
    ConsultarLoteRpsRespostaBetha consultarLoteRpsRespostaBetha = null;
    String xml = XmlFake.get("consultarLoteRps.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    try {
      consultarLoteRpsRespostaBetha = WebServiceBetha.consultarLoteRps(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertNotNull(consultarLoteRpsRespostaBetha);
  }
}
