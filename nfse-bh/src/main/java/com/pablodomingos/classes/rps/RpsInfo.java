package com.pablodomingos.classes.rps;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.rps.enums.RpsStatus;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class RpsInfo {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  @NotNull
  @Size(min=1, max=255)
  private String id;

  @XStreamAlias("IdentificacaoRps")
  @NotNull
  private RpsIdentificacao identificacaoRps;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  @NotNull
  private LocalDateTime dataEmissao;

  @XStreamAlias("NaturezaOperacao")
  @NotNull
  private NaturezaOperacao naturezaOperacao;

  @XStreamAlias("RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @XStreamAlias("IncentivadorCultural")
  @NotNull
  private IncentivadorCultural incentivadorCultural;

  @XStreamAlias("Status")
  @NotNull
  private RpsStatus status;

  @XStreamAlias("RpsSubstituido")
  private RpsIdentificacao rpsSubstituido;
  
  @XStreamAlias("Servico")
  @NotNull
  private RpsServico servico;

  @XStreamAlias("Prestador")
  @NotNull
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
    rpsSubstituido = builder.getRpsSubstituido();
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

  public RpsIdentificacao getIdentificacaoRps() {
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
