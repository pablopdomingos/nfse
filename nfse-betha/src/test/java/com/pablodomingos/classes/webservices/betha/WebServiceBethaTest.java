package com.pablodomingos.classes.webservices.betha;

import com.pablodomingos.assinatura.AssinaturaDigitalBetha;
import com.pablodomingos.classes.CertificadoConfigFake;
import com.pablodomingos.classes.FabricaDeBuildersFake;
import com.pablodomingos.classes.XmlFake;
import com.pablodomingos.classes.respostas.*;
import com.pablodomingos.classes.rps.CompNfse;
import com.pablodomingos.classes.rps.LoteRpsBetha;
import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import com.pablodomingos.classes.servicos.LoteRpsConsultaBetha;
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

  //  @Test
  public void gerarCacerts() {
    try {
      FileUtils.writeByteArrayToFile(new File("/tmp/nfse-betha.cacerts"), NFSeGeraCadeiaCertificadosBetha.geraCadeiaCertificados("senha"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //  @Test
  public void testaGerarNfse() {
    GerarNfseRespostaBetha gerarNfseRespostaBetha = null;
    String xml = XmlFake.get("/tmp/GerarNfse.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    int numero = random.nextInt(Integer.MAX_VALUE);
    try {
      xml = xml.replace("{NUMERO}", String.valueOf(numero));
      AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
      xml = assinatura.assinarXML(xml);
      System.out.println("xml = " + xml);
      gerarNfseRespostaBetha = WebServiceBetha.gerarNfse(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(gerarNfseRespostaBetha.getListaNfse().get(0).getNfse().getInfNfse().getPrestadorServico().getEndereco().getEndereco(), "Ambiente de testes não requer endereço");
  }

  //  @Test
  public void testaCancelarNfse() {
    CancelarNfseRespostaBetha cancelarNfseRespostaBetha = null;
    String xml = XmlFake.get("/tmp/cancelarNfse.xml");
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
    Assert.assertNotNull(cancelarNfseRespostaBetha.getRetCancelamento());
  }

  //  @Test
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
  public void consultarNfseServicoPrestado() {
    ConsultarNfseServicoPrestadoRespostaBetha consultarNfseServicoPrestadoRespostaBetha = null;
    String xml = XmlFake.get("/tmp/consultarNfseServicoPrestado.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    try {
      consultarNfseServicoPrestadoRespostaBetha = WebServiceBetha.consultarNfseServicoPrestado(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(consultarNfseServicoPrestadoRespostaBetha
            .getListaNfse()
            .get(0)
            .getNfse()
            .getInfNfse()
            .getDeclaracaoPrestacaoServico()
            .getRpsInfo()
            .getRps()
            .getIdentificacaoRps()
            .getNumero(),
        "1");
  }

  @Test
  public void consultarNfseServicoTomado() {
    ConsultarNfseServicoTomadoRespostaBetha consultarNfseServicoTomadoRespostaBetha = null;
    String xml = XmlFake.get("/tmp/consultarNfseServicoTomado.xml");
    if (xml == null) {
      Assert.assertNull(xml);
      return;
    }
    System.out.println("xml = " + xml);
    try {
      consultarNfseServicoTomadoRespostaBetha = WebServiceBetha.consultarNfseServicoTomado(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(consultarNfseServicoTomadoRespostaBetha
            .getListaNfse()
            .get(0)
            .getNfse()
            .getInfNfse()
            .getDeclaracaoPrestacaoServico()
            .getRpsInfo()
            .getRps()
            .getIdentificacaoRps()
            .getNumero(),
        "1");
  }

  //  @Test
  public void testaConsulta() {
    ConsultarLoteRpsRespostaBetha consultarLoteRpsResposta = null;
    RpsPrestadorBetha prestador = new RpsPrestadorBetha(FabricaDeBuildersFake.getRpsPrestadorBuilder());
    LoteRpsConsultaBetha consultaLote = new LoteRpsConsultaBetha("61179746508803", prestador);
    String xml = consultaLote.converterParaXml();
    try {
      consultarLoteRpsResposta = WebServiceBetha.consultarLoteRps(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(consultarLoteRpsResposta.getSituacao(), SituacaoLoteRps.PROCESSADO_COM_SUCESSO);
  }
}
