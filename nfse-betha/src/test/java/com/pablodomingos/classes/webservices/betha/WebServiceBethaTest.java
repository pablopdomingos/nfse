package com.pablodomingos.classes.webservices.betha;

import com.pablodomingos.assinatura.AssinaturaDigitalBetha;
import com.pablodomingos.classes.CertificadoConfigFake;
import com.pablodomingos.classes.FabricaDeBuildersFake;
import com.pablodomingos.classes.rps.*;
import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import com.pablodomingos.classes.rps.respostas.CancelarNfseRespostaBetha;
import com.pablodomingos.classes.rps.respostas.ConsultarLoteRpsRespostaBetha;
import com.pablodomingos.classes.rps.respostas.EnviarLoteRpsRespostaBetha;
import com.pablodomingos.classes.rps.servicos.LoteRpsConsultaBetha;
import com.pablodomingos.classes.rps.servicos.LoteRpsEnvioBetha;
import com.pablodomingos.classes.rps.servicos.NFSeCancelamentoBetha;
import com.pablodomingos.classes.rps.servicos.RpsEnvioBetha;
import com.pablodomingos.utils.NFSeGeraCadeiaCertificadosBetha;
import com.pablodomingos.webservices.betha.WebServiceBetha;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class WebServiceBethaTest {
//  @Test
  public void gerarCacerts() {
    try {
      FileUtils.writeByteArrayToFile(new File("/tmp/nfse-betha2.cacerts"), NFSeGeraCadeiaCertificadosBetha.geraCadeiaCertificados("senha"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testaEnvioRPs() {
    CancelarNfseRespostaBetha cancelarNfseRespostaBetha = null;
//    LoteRpsBetha loteRpsBetha = new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
//    LoteRpsEnvioBetha loteRpsEnvio = new LoteRpsEnvioBetha(loteRpsBetha);
//    String xml = loteRpsEnvio.converterParaXml();
//    PedidoCancelamentoInfBuilder pedidoCancelamentoInfBuilder = FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder();
//    pedidoCancelamentoInfBuilder
//        .comNumero("1")
//        .comCodigoCancelamento(CodigoCancelamento.ERRO_NA_EMISSAO)
//        .comCnpj("03383790000120")
//        .comInscricaoMunicipal("0")
//        .comCodigoMunicipioIbge("0");
    RpsEnvioBetha rpsEnvioBetha = new RpsEnvioBetha(new RpsBetha(FabricaDeBuildersFake.getRpsInfoBuilder()));

//    NFSeCancelamentoBetha nfseCancelamentoBetha = new NFSeCancelamentoBetha(
//        new NFSePedidoCancelamentoBetha(
//            new NFSeInfPedidoCancelamentoBetha(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder())
//        )
//    );
    String xml = rpsEnvioBetha.converterParaXml();
    System.out.println("xml = " + xml);
    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
    try {
      xml = assinatura.assinarXML(xml);
//      System.out.println("xml = " + xml);
      cancelarNfseRespostaBetha = WebServiceBetha.gerarNfse(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("cancelarNfseRespostaBetha = " + cancelarNfseRespostaBetha);
//    Asser
  }

//  @Test
  public void testaCancelarLote() {
    CancelarNfseRespostaBetha cancelarNfseRespostaBetha = null;
//    LoteRpsBetha loteRpsBetha = new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
//    LoteRpsEnvioBetha loteRpsEnvio = new LoteRpsEnvioBetha(loteRpsBetha);
//    String xml = loteRpsEnvio.converterParaXml();
//    PedidoCancelamentoInfBuilder pedidoCancelamentoInfBuilder = FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder();
//    pedidoCancelamentoInfBuilder
//        .comNumero("1")
//        .comCodigoCancelamento(CodigoCancelamento.ERRO_NA_EMISSAO)
//        .comCnpj("03383790000120")
//        .comInscricaoMunicipal("0")
//        .comCodigoMunicipioIbge("0");
    NFSeCancelamentoBetha nfseCancelamentoBetha = new NFSeCancelamentoBetha(
        new NFSePedidoCancelamentoBetha(
            new NFSeInfPedidoCancelamentoBetha(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder())
        )
    );
    String xml = nfseCancelamentoBetha.converterParaXml();
//    System.out.println("xml = " + xml);
    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(CertificadoConfigFake.get());
    try {
      xml = assinatura.assinarXML(xml);
      System.out.println("xml = " + xml);
      cancelarNfseRespostaBetha = WebServiceBetha.cancelarNfse(xml, CertificadoConfigFake.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("cancelarNfseRespostaBetha = " + cancelarNfseRespostaBetha);
//    Assert.assertEquals(enviarLoteRpsRespostaBetha.getNumeroLote(), loteRpsBetha.getNumeroLote());
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
