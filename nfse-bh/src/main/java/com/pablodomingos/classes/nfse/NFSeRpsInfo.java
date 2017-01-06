package com.pablodomingos.classes.nfse;

import java.time.LocalDateTime;

import com.pablodomingos.classes.nfse.builders.RpsInfoBuilder;
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
  private String id;

  @XStreamAlias("IdentificacaoRps")
  private NFSeRpsInfoIdentificacaoRps identificacaoRps ;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime dataEmissao;

  @XStreamAlias("NaturezaOperacao")
  private NaturezaOperacao naturezaOperacao;

  @XStreamAlias("RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  private OptanteSimplesNacional optanteSimplesNacional;

  @XStreamAlias("IncentivadorCultural")
  private IncentivadorCultural incentivadorCultural;

  @XStreamAlias("Status")
  private RpsStatus status;

  @XStreamAlias("Servico")
  private NFSeServico servico;

  @XStreamAlias("Prestador")
  private NFSePrestador prestador;

  @XStreamAlias("Tomador")
  private NFSeTomador tomador;

  @XStreamAlias("Intermediario")
  private NFSeIntermediario intermediario;

  public NFSeRpsInfo(RpsInfoBuilder builder) {
    id = builder.getId();
    identificacaoRps = builder.getIdentificacaoRps();
    dataEmissao = builder.getDataEmissao();
    naturezaOperacao = builder.getNaturezaOperacao();
    regimeEspecialTributacao = builder.getRegimeEspecialTributacao();
    optanteSimplesNacional = builder.getOptanteSimplesNacional();
    incentivadorCultural = builder.getIncentivadorCultural();
    status = builder.getStatus();
    servico = builder.getServico();
    prestador = builder.getPrestador();
    tomador = builder.getTomador();
    intermediario = builder.getIntermediario();
  }

  public String getId() {
    return id;
  }

  public NFSeServico getServico() {
    return servico;
  }

  public NFSePrestador getPrestador() {
    return prestador;
  }

  public NFSeTomador getTomador() {
    return tomador;
  }

  public NFSeIntermediario getIntermediario() {
    return intermediario;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public NFSeRpsInfoIdentificacaoRps getIdentificacaoRps() {
    return identificacaoRps;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public RpsStatus getStatus() {
    return status;
  }

  public NaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

}
