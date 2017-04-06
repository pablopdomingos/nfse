package com.pablodomingos.classes.webservices.betha;

import com.pablodomingos.assinatura.AssinaturaDigitalBetha;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.FabricaDeBuildersFake;
import com.pablodomingos.classes.rps.LoteRpsBetha;
import com.pablodomingos.classes.rps.NFSeInfPedidoCancelamentoBetha;
import com.pablodomingos.classes.rps.NFSePedidoCancelamentoBetha;
import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import com.pablodomingos.classes.rps.respostas.CancelarNfseRespostaBetha;
import com.pablodomingos.classes.rps.respostas.ConsultarLoteRpsRespostaBetha;
import com.pablodomingos.classes.rps.respostas.EnviarLoteRpsRespostaBetha;
import com.pablodomingos.classes.rps.servicos.LoteRpsConsultaBetha;
import com.pablodomingos.classes.rps.servicos.LoteRpsEnvioBetha;
import com.pablodomingos.classes.rps.servicos.NFSeCancelamentoBetha;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.webservices.betha.WebServiceBetha;
import org.junit.Assert;
import org.junit.Test;

public class WebServiceBethaTest {
  static CertificadoConfig certificadoConfig = new CertificadoConfig(
      new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, "senha")
          .comCaminhoCertificadoCliente(WebServiceBethaTest.class.getClassLoader().getResource("homologacao.pfx").getPath())
          .comCaminhoCadeiaDeCertificados(WebServiceBethaTest.class.getClassLoader().getResource("nfse-betha.cacerts").getPath())
          .comAmbiente(NFSeAmbiente.HOMOLOGACAO));

  @Test
  public void cancelarLote() {
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
    System.out.println("xml = " + xml);
    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(certificadoConfig);
    try {
      xml = assinatura.assinarXML(xml);
      cancelarNfseRespostaBetha = WebServiceBetha.cancelarNfse(xml, certificadoConfig);
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
    AssinaturaDigitalBetha assinatura = new AssinaturaDigitalBetha(certificadoConfig);
    try {
      xml = assinatura.assinarXML(xml);
      enviarLoteRpsRespostaBetha = WebServiceBetha.enviarLoteRps(xml, certificadoConfig);
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
      consultarLoteRpsResposta = WebServiceBetha.consultarLoteRps(xml, certificadoConfig);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Assert.assertEquals(consultarLoteRpsResposta.getSituacao(), SituacaoLoteRps.PROCESSADO_COM_SUCESSO);
  }
}
