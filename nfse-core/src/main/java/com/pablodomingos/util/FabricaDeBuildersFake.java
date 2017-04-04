package com.pablodomingos.util;

import com.pablodomingos.classes.rps.builders.*;
import com.pablodomingos.classes.rps.enums.*;

public class FabricaDeBuildersFake {

  public static TomadorBuilder getTomadorBuilder() {
    return new TomadorBuilder("12345678909")
      .comNome("Nome Tomador")
      .comLogradouro("Logradouro")
      .comNumeroEndereco("1234")
      .comComplemento("Complemento")
      .comBairro("Bairro")
      .comCep("00000000")
      .comCodigoMunicipio("3118601")
      .comUf("MG")
      .comTelefone("00000000000")
      .comEmail("email@gmail.com");
  }

  public static PrestadorBuilder getRpsPrestadorBuilder() {
    return new PrestadorBuilder("12345678901230")
        .comInscricaoMunicipal("000000000000000");
  }
  
  public static IntermediarioBuilder getIntermediarioBuilder(){
    return new IntermediarioBuilder("12345678901230", "Nome Intermediario")
        .comInscricaoMunicipal("000000000000000");
  }

  public static ValoresBuilder getValoresBuilder(){
      return new ValoresBuilder(100.00, 1.0)
          .comValorPis(2.00)
          .comValorCofins(3.00)
          .comValorInss(4.00)
          .comValorIr(5.00)
          .comValorCsll(6.00)
          .comValorDeducoes(7.00)
          .comDescontoCondicionado(8.00)
          .comDescontoIncondicionado(9.00)
          .comOutrasRetencoes(10.00)
          .comIssRetido(false);
  }

  public static ServicoBuilder getServicoBuilder() {
    return new ServicoBuilder(getValoresBuilder(), "01.01")
      .comCodigoCnae(12345)
      .comCodigoMunicipio(3106200)
      .comCodigoTributacaoMunicipio("110200188")
      .comDiscriminacao("Discriminacao teste")
      .comExigibilidadeISS(ExigibilidadeIss.EXIGIVEL);
  }

  public static RpsInfoBuilder getRpsInfoBuilder(){
    return new RpsInfoBuilder("1")
        .comId("1")
        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(true)
        .comPrestador(getRpsPrestadorBuilder())
        .comRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL)
        .comServico(getServicoBuilder())
        .comStatus(RpsStatus.NORMAL)
        .comTomador(getTomadorBuilder());
  }

  public static LoteRpsBuilder getLoteRpsBuilder(){
    return new LoteRpsBuilder("1")
        .comId("id")
        .comCnpj("12345678901230")
        .comInscricaoMunicipal("000000000000000")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(getRpsInfoBuilder());
  }

  public static PedidoCancelamentoInfBuilder getPedidoCancelamentoInfBuilder(){
    return new PedidoCancelamentoInfBuilder()
        .comId("id")
        .comCodigoCancelamento(CodigoCancelamento.SERVICO_NAO_CONCLUIDO)
        .comCnpj("12345678901230")
        .comInscricaoMunicipal("000000000000000")
        .comCodigoMunicipioIbge("3106200")
        .comNumero("201700000000001");
  }
}
