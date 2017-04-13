package com.pablodomingos.webservices.bh;

import com.pablodomingos.assinatura.AssinaturaDigitalBH;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.FabricaDeBuildersFake;
import com.pablodomingos.classes.rps.LoteRpsBH;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.respostas.GerarNfseRespostaBH;
import com.pablodomingos.classes.servicos.RpsEnvioBH;
import com.pablodomingos.config.CertificadoConfig;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WebServiceBHTest {
  static CertificadoConfig certificadoConfig = new CertificadoConfig(
      new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, "senha")
          .comCaminhoCertificadoCliente(WebServiceBHTest.class.getClassLoader().getResource("homologacao.pfx").getPath())
          .comCaminhoCadeiaDeCertificados(WebServiceBHTest.class.getClassLoader().getResource("nfse-bh.cacerts").getPath())
          .comAmbiente(NFSeAmbiente.HOMOLOGACAO));

  @Test
  public void testaEnvioRPs() {
    String senha = "";
    try(FileInputStream inputStream = new FileInputStream("/tmp/senha.txt")) {
      senha = IOUtils.toString(inputStream);
      // do something with everything string
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("senha = " + senha);
    certificadoConfig = new CertificadoConfig(
        new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, senha)
            .comCaminhoCertificadoCliente("/tmp/certificado.pfx")
            .comCaminhoCadeiaDeCertificados(WebServiceBHTest.class.getClassLoader().getResource("nfse-bh.cacerts").getPath())
            .comAmbiente(NFSeAmbiente.HOMOLOGACAO));

    GerarNfseRespostaBH gerarNfseResposta = null;
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
    RpsEnvioBH rpsEnvioBH = new RpsEnvioBH(new LoteRpsBH(FabricaDeBuildersFake.getLoteRpsBuilder()));

//    NFSeCancelamentoBetha nfseCancelamentoBetha = new NFSeCancelamentoBetha(
//        new NFSePedidoCancelamentoBetha(
//            new NFSeInfPedidoCancelamentoBetha(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder())
//        )
//    );
    String xml = rpsEnvioBH.converterParaXml();
//    System.out.println("xml = " + xml);
    AssinaturaDigitalBH assinatura = new AssinaturaDigitalBH(certificadoConfig);
    try {
      xml = assinatura.assinarXML(xml);
      System.out.println("xml = " + xml);
      gerarNfseResposta = WebServiceBH.gerarNfse(xml, certificadoConfig);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("cancelarNfseRespostaBetha = " + gerarNfseResposta);
//    Asser
  }
//
////  @Test
//  public void testaCancelarLote() {
//    String senha = "";
//    try(FileInputStream inputStream = new FileInputStream("/tmp/senha.txt")) {
//      senha = IOUtils.toString(inputStream);
//      // do something with everything string
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    certificadoConfig = new CertificadoConfig(
//        new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, senha)
//            .comCaminhoCertificadoCliente("/tmp/certificado.pfx")
//            .comCaminhoCadeiaDeCertificados(WebServiceBethaTest.class.getClassLoader().getResource("nfse-betha.cacerts").getPath())
//            .comAmbiente(NFSeAmbiente.HOMOLOGACAO));
//
//    CancelarNfseRespostaBetha cancelarNfseRespostaBetha = null;
////    LoteRpsBetha loteRpsBetha = new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
////    LoteRpsEnvioBetha loteRpsEnvio = new LoteRpsEnvioBetha(loteRpsBetha);
////    String xml = loteRpsEnvio.converterParaXml();
////    PedidoCancelamentoInfBuilder pedidoCancelamentoInfBuilder = FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder();
////    pedidoCancelamentoInfBuilder
////        .comNumero("1")
////        .comCodigoCancelamento(CodigoCancelamento.ERRO_NA_EMISSAO)
////        .comCnpj("03383790000120")
////        .comInscricaoMunicipal("0")
////        .comCodigoMunicipioIbge("0");
//    NFSeCancelamentoBetha nfseCancelamentoBetha = new NFSeCancelamentoBetha(
//        new NFSePedidoCancelamentoBetha(
//            new NFSeInfPedidoCancelamentoBetha(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder())
//        )
//    );
//    String xml = nfseCancelamentoBetha.converterParaXml();
////    System.out.println("xml = " + xml);
//    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(certificadoConfig);
//    try {
//      xml = assinatura.assinarXML(xml);
//      System.out.println("xml = " + xml);
//      cancelarNfseRespostaBetha = WebServiceBetha.cancelarNfse(xml, certificadoConfig);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    System.out.println("cancelarNfseRespostaBetha = " + cancelarNfseRespostaBetha);
////    Assert.assertEquals(enviarLoteRpsRespostaBetha.getNumeroLote(), loteRpsBetha.getNumeroLote());
//  }
//
////  @Test
//  public void testaGeracaoLote() {
//    EnviarLoteRpsRespostaBetha enviarLoteRpsRespostaBetha = null;
//    LoteRpsBetha loteRpsBetha = new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
//    LoteRpsEnvioBetha loteRpsEnvio = new LoteRpsEnvioBetha(loteRpsBetha);
//    String xml = loteRpsEnvio.converterParaXml();
//    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(certificadoConfig);
//    try {
//      xml = assinatura.assinarXML(xml);
//      enviarLoteRpsRespostaBetha = WebServiceBetha.enviarLoteRps(xml, certificadoConfig);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    Assert.assertEquals(enviarLoteRpsRespostaBetha.getNumeroLote(), loteRpsBetha.getNumeroLote());
//  }
//
////  @Test
//  public void testaConsulta() {
//    ConsultarLoteRpsRespostaBetha consultarLoteRpsResposta = null;
//    RpsPrestadorBetha prestador = new RpsPrestadorBetha(FabricaDeBuildersFake.getRpsPrestadorBuilder());
//    LoteRpsConsultaBetha consultaLote = new LoteRpsConsultaBetha("61179746508803", prestador);
//    String xml = consultaLote.converterParaXml();
//    try {
//      consultarLoteRpsResposta = WebServiceBetha.consultarLoteRps(xml, certificadoConfig);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    Assert.assertEquals(consultarLoteRpsResposta.getSituacao(), SituacaoLoteRps.PROCESSADO_COM_SUCESSO);
//  }
}
