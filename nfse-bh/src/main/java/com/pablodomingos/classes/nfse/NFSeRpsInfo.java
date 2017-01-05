package com.pablodomingos.classes.nfse;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class NFSeRpsInfo {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("IdentificacaoRps")
  private NFSeRpsInfoIdentificacaoRps identificacaoRps;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime dataEmissao;

  @XStreamAlias("NaturezaOperacao")
  private NFSeRpsInfoNaturezaOperacao naturezaOperacao;

  @XStreamAlias("RegimeEspecialTributacao")
  private NFSeRpsInfoRegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  private NFSeRpsInfoOptanteSimplesNacional optanteSimplesNacional;

  @XStreamAlias("IncentivadorCultural")
  private NFSeRpsInfoIncentivadorCultural incentivadorCultural;

  @XStreamAlias("Status")
  private NFSeRpsInfoStatus status;

  @XStreamAlias("Servico")
  private NFSeRpsInfoServico servico;

  @XStreamAlias("Prestador")
  private NFSeRpsInfoServicoPrestador prestador;

  @XStreamAlias("Tomador")
  private NFSeRpsInfoServicoTomador tomador;

  @XStreamAlias("Intermediario")
  private NFSeRpsInfoServicoIntermediario intermediario;

  public NFSeRpsInfo() {
    identificacaoRps = new NFSeRpsInfoIdentificacaoRps();
    dataEmissao = LocalDateTime.now();
    naturezaOperacao = NFSeRpsInfoNaturezaOperacao.TRIBUTACAO_MUNICIPIO;
    optanteSimplesNacional = NFSeRpsInfoOptanteSimplesNacional.NAO;
    incentivadorCultural = NFSeRpsInfoIncentivadorCultural.NAO;
    status = NFSeRpsInfoStatus.NORMAL;
    id = UUID.randomUUID().toString();
  }

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

  public NFSeRpsInfoServicoPrestador getPrestador() {
    return prestador;
  }

  public void setPrestador(NFSeRpsInfoServicoPrestador prestador) {
    this.prestador = prestador;
  }

  public NFSeRpsInfoServicoTomador getTomador() {
    return tomador;
  }

  public void setTomador(NFSeRpsInfoServicoTomador tomador) {
    this.tomador = tomador;
  }

  public NFSeRpsInfoServicoIntermediario getIntermediario() {
    return intermediario;
  }

  public void setIntermediario(NFSeRpsInfoServicoIntermediario intermediario) {
    this.intermediario = intermediario;
  }

  public NFSeRpsInfoOptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public void setOptanteSimplesNacional(NFSeRpsInfoOptanteSimplesNacional optanteSimplesNacional) {
    this.optanteSimplesNacional = optanteSimplesNacional;
  }

  public NFSeRpsInfoIncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public void setIncentivadorCultural(NFSeRpsInfoIncentivadorCultural IncentivadorCultural) {
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

  public NFSeRpsInfoStatus getStatus() {
    return status;
  }

  public void setStatus(NFSeRpsInfoStatus status) {
    this.status = status;
  }

  public NFSeRpsInfoNaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public void setNaturezaOperacao(NFSeRpsInfoNaturezaOperacao naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
  }

  public NFSeRpsInfoRegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public void setRegimeEspecialTributacao(
      NFSeRpsInfoRegimeEspecialTributacao regimeEspecialTributacao) {
    this.regimeEspecialTributacao = regimeEspecialTributacao;
  }

}
