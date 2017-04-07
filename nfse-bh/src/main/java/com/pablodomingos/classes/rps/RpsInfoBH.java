package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.*;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RpsInfoBH extends AbstractRPS {

  @Attribute(name = "Id")
  @NotNull
  @Size(min = 1, max = 255)
  private String id;

  @Element(name = "IdentificacaoRps")
  @NotNull
  @Valid
  private RpsIdentificacaoBH identificacaoRps;

  @Element(name = "DataEmissao")
  @NotNull
  private LocalDateTime dataEmissao;

  @Element(name = "NaturezaOperacao")
  @NotNull
  private NaturezaOperacao naturezaOperacao;

  @Element(name = "RegimeEspecialTributacao", required = false)
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @Element(name = "OptanteSimplesNacional")
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @Element(name = "IncentivadorCultural")
  @NotNull
  private IncentivadorCultural incentivadorCultural;

  @Element(name = "Status")
  @NotNull
  private RpsStatus status;

  @Element(name = "RpsSubstituido", required = false)
  @Valid
  private RpsIdentificacaoBH rpsSubstituido;

  @Element(name = "Servico")
  @NotNull
  @Valid
  private RpsServicoBH servico;

  @Element(name = "Prestador")
  @NotNull
  @Valid
  private RpsPrestadorBH prestador;

  @Element(name = "Tomador", required = false)
  @Valid
  private RpsTomadorBH tomador;

  @Element(name = "IntermediarioServico", required = false)
  @Valid
  private RpsIntermediarioBH intermediario;

  @Element(name = "ConstrucaoCivil", required = false)
  @Valid
  private RpsDadosContrucaoCivilBH construcaoCivil;

  public RpsInfoBH(RpsInfoBuilder builder) {
    id = builder.getId();
    identificacaoRps = new RpsIdentificacaoBH(builder.getId(), builder.getSerie());
    dataEmissao = builder.getDataEmissao();
    naturezaOperacao = builder.getNaturezaOperacao();
    regimeEspecialTributacao = builder.getRegimeEspecialTributacao();
    optanteSimplesNacional = builder.getOptanteSimplesNacional();
    incentivadorCultural = builder.getIncentivadorCultural();
    status = builder.getStatus();
    if (builder.getContrucaoCivil() != null)
      construcaoCivil = new RpsDadosContrucaoCivilBH(builder.getContrucaoCivil());
    servico = new RpsServicoBH(builder.getServico());
    prestador = new RpsPrestadorBH(builder.getPrestador());
    tomador = new RpsTomadorBH(builder.getTomador());
    if (builder.getIntermediario() != null)
      intermediario = new RpsIntermediarioBH(builder.getIntermediario());
    if (builder.getIdSubstituido() != null && builder.getSerieSubstituido() != null)
      rpsSubstituido = new RpsIdentificacaoBH(builder.getIdSubstituido(), builder.getSerieSubstituido());
  }

  public String getId() {
    return id;
  }

  public RpsServicoBH getServico() {
    return servico;
  }

  public RpsPrestadorBH getPrestador() {
    return prestador;
  }

  public RpsTomadorBH getTomador() {
    return tomador;
  }

  public RpsIntermediarioBH getIntermediario() {
    return intermediario;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public RpsIdentificacaoBH getIdentificacaoRps() {
    return identificacaoRps;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public RpsStatus getStatus() {
    return status;
  }

  public RpsIdentificacaoBH getRpsSubstituido() {
    return rpsSubstituido;
  }

  public NaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public RpsDadosContrucaoCivilBH getConstrucaoCivil() {
    return construcaoCivil;
  }

}
