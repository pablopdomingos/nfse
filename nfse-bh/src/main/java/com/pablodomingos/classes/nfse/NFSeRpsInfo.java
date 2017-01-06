package com.pablodomingos.classes.nfse;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pablodomingos.classes.nfse.enums.IncentivadorCultural;
import com.pablodomingos.classes.nfse.enums.NaturezaOperacao;
import com.pablodomingos.classes.nfse.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.nfse.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.nfse.enums.RpsStatus;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class NFSeRpsInfo {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  private String id = UUID.randomUUID().toString();

  @XStreamAlias("IdentificacaoRps")
  private NFSeRpsInfoIdentificacaoRps identificacaoRps ;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime dataEmissao = LocalDateTime.now();

  @XStreamAlias("NaturezaOperacao")
  private NaturezaOperacao naturezaOperacao = NaturezaOperacao.TRIBUTACAO_MUNICIPIO;

  @XStreamAlias("RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  private OptanteSimplesNacional optanteSimplesNacional = OptanteSimplesNacional.NAO;

  @XStreamAlias("IncentivadorCultural")
  private IncentivadorCultural incentivadorCultural  = IncentivadorCultural.NAO;

  @XStreamAlias("Status")
  private RpsStatus status = RpsStatus.NORMAL;

  @XStreamAlias("Servico")
  private NFSeRpsInfoServico servico;

  @XStreamAlias("Prestador")
  private NFSePrestador prestador;

  @XStreamAlias("Tomador")
  private NFSeTomador tomador;

  @XStreamAlias("Intermediario")
  private NFSeRpsInfoServicoIntermediario intermediario;

  public NFSeRpsInfo() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NFSeRpsInfoServico getServico() {
    return servico;
  }

  public void setServico(NFSeRpsInfoServico servico) {
    this.servico = servico;
  }

  public NFSePrestador getPrestador() {
    return prestador;
  }

  public void setPrestador(NFSePrestador prestador) {
    this.prestador = prestador;
  }

  public NFSeTomador getTomador() {
    return tomador;
  }

  public void setTomador(NFSeTomador tomador) {
    this.tomador = tomador;
  }

  public NFSeRpsInfoServicoIntermediario getIntermediario() {
    return intermediario;
  }

  public void setIntermediario(NFSeRpsInfoServicoIntermediario intermediario) {
    this.intermediario = intermediario;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public void setOptanteSimplesNacional(OptanteSimplesNacional optanteSimplesNacional) {
    this.optanteSimplesNacional = optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public void setIncentivadorCultural(IncentivadorCultural IncentivadorCultural) {
    this.incentivadorCultural = IncentivadorCultural;
  }

  public NFSeRpsInfoIdentificacaoRps getIdentificacaoRps() {
    return identificacaoRps;
  }

  public void setIdentificacaoRps(NFSeRpsInfoIdentificacaoRps identificacaoRps) {
    this.identificacaoRps = identificacaoRps;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(LocalDateTime dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public RpsStatus getStatus() {
    return status;
  }

  public void setStatus(RpsStatus status) {
    this.status = status;
  }

  public NaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public void setNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public void setRegimeEspecialTributacao(
      RegimeEspecialTributacao regimeEspecialTributacao) {
    this.regimeEspecialTributacao = regimeEspecialTributacao;
  }

}
