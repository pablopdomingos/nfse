package com.pablodomingos.classes.rps;

import java.time.LocalDateTime;

import com.pablodomingos.classes.enums.IncentivadorCultural;
import com.pablodomingos.classes.enums.NaturezaOperacao;
import com.pablodomingos.classes.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.enums.RpsStatus;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class RpsInfo {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("IdentificacaoRps")
  private RpsIdentificacaoRps identificacaoRps ;

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
  private RpsServico servico;

  @XStreamAlias("Prestador")
  private RpsPrestador prestador;

  @XStreamAlias("Tomador")
  private RpsTomador tomador;

  @XStreamAlias("IntermediarioServico")
  private RpsIntermediario intermediario;
  
  @XStreamAlias("ConstrucaoCivil")
  private RpsDadosContrucaoCivil construcaoCivil;

  public RpsInfo(RpsInfoBuilder builder) {
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

  public RpsServico getServico() {
    return servico;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }

  public RpsTomador getTomador() {
    return tomador;
  }

  public RpsIntermediario getIntermediario() {
    return intermediario;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public RpsIdentificacaoRps getIdentificacaoRps() {
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

  public RpsDadosContrucaoCivil getConstrucaoCivil() {
    return construcaoCivil;
  }

}
