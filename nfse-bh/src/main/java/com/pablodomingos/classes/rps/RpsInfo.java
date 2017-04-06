package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.*;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RpsInfo extends AbstractRPS {

  @Element(name="Id")
  @Attribute
  @NotNull
  @Size(min=1, max=255)
  private String id;

  @Element(name="IdentificacaoRps")
  @NotNull
  @Valid
  private RpsIdentificacao identificacaoRps;

  @Element(name="DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  @NotNull
  private LocalDateTime dataEmissao;

  @Element(name="NaturezaOperacao")
  @NotNull
  private NaturezaOperacao naturezaOperacao;

  @Element(name="RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @Element(name="OptanteSimplesNacional")
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @Element(name="IncentivadorCultural")
  @NotNull
  private IncentivadorCultural incentivadorCultural;

  @Element(name="Status")
  @NotNull
  private RpsStatus status;

  @Element(name="RpsSubstituido")
  @Valid
  private RpsIdentificacao rpsSubstituido;
  
  @Element(name="Servico")
  @NotNull
  @Valid
  private RpsServico servico;

  @Element(name="Prestador")
  @NotNull
  @Valid
  private RpsPrestador prestador;

  @Element(name="Tomador")
  @Valid
  private RpsTomador tomador;

  @Element(name="IntermediarioServico")
  @Valid
  private RpsIntermediario intermediario;
  
  @Element(name="ConstrucaoCivil")
  @Valid
  private RpsDadosContrucaoCivil construcaoCivil;

  public RpsInfo(RpsInfoBuilder builder) {
    id = builder.getId();
    identificacaoRps = new RpsIdentificacao(builder.getId(), builder.getSerie());
    dataEmissao = builder.getDataEmissao();
    naturezaOperacao = builder.getNaturezaOperacao();
    regimeEspecialTributacao = builder.getRegimeEspecialTributacao();
    optanteSimplesNacional = builder.getOptanteSimplesNacional();
    incentivadorCultural = builder.getIncentivadorCultural();
    status = builder.getStatus();
    if (builder.getContrucaoCivil() != null)
      construcaoCivil = new RpsDadosContrucaoCivil(builder.getContrucaoCivil());
    servico = new RpsServico(builder.getServico());
    prestador = new RpsPrestador(builder.getPrestador());
    tomador = new RpsTomador(builder.getTomador());
    if (builder.getIntermediario() != null)
      intermediario = new RpsIntermediario(builder.getIntermediario());
    if (builder.getIdSubstituido() != null && builder.getSerieSubstituido() != null)
      rpsSubstituido = new RpsIdentificacao(builder.getIdSubstituido(), builder.getSerieSubstituido());
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

  public RpsIdentificacao getRpsSubstituido() {
    return rpsSubstituido;
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
