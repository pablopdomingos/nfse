package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.*;
import com.pablodomingos.conversores.LocalDateConversor;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RpsInfo extends AbstractRPS {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  @NotNull
  @Size(min=1, max=255)
  private String id;

  @XStreamAlias("Rps")
  @NotNull
  @Valid
  private RpsInfoIdentificacao rps;

  @XStreamAlias("Competencia")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate competencia;

  @XStreamAlias("RpsSubstituido")
  @Valid
  private RpsIdentificacao rpsSubstituido;
  
  @XStreamAlias("Servico")
  @NotNull
  @Valid
  private RpsServico servico;

  @XStreamAlias("Prestador")
  @NotNull
  @Valid
  private RpsPrestador prestador;

  @XStreamAlias("Tomador")
  @Valid
  private RpsTomador tomador;

  @XStreamAlias("IntermediarioServico")
  @Valid
  private RpsIntermediario intermediario;
  
  @XStreamAlias("ConstrucaoCivil")
  @Valid
  private RpsDadosContrucaoCivil construcaoCivil;

  @XStreamAlias("RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @XStreamAlias("IncentivoFiscal")
  @NotNull
  private IncentivadorCultural incentivadorCultural;

  public RpsInfo(RpsInfoBuilder builder) {
    competencia = LocalDate.now();
    id = builder.getId();
    rps = new RpsInfoIdentificacao(
        new RpsIdentificacao(builder.getId(), builder.getSerie()),
        builder.getDataEmissao().toLocalDate(),
        builder.getStatus()
    );
    if (builder.getContrucaoCivil() != null)
      construcaoCivil = new RpsDadosContrucaoCivil(builder.getContrucaoCivil());
    regimeEspecialTributacao = builder.getRegimeEspecialTributacao();
    optanteSimplesNacional = builder.getOptanteSimplesNacional();
    incentivadorCultural = builder.getIncentivadorCultural();
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

  public RpsIdentificacao getRpsSubstituido() {
    return rpsSubstituido;
  }

  public RpsDadosContrucaoCivil getConstrucaoCivil() {
    return construcaoCivil;
  }

  public RpsInfoIdentificacao getRps() {
    return rps;
  }

  public LocalDate getCompetencia() {
    return competencia;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }
}
