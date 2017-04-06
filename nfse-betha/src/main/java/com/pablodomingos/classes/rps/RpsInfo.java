package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.conversores.LocalDateConversor;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RpsInfo extends AbstractRPS {

  @Attribute(name="Id")
  @NotNull
  @Size(min=1, max=255)
  private String id;

  @Element(name="Rps")
  @NotNull
  @Valid
  private RpsInfoIdentificacao rps;

  @Element(name="Competencia")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate competencia;

  @Element(name="RpsSubstituido", required = false)
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

  @Element(name="Tomador", required = false)
  @Valid
  private RpsTomador tomador;

  @Element(name="IntermediarioServico", required = false)
  @Valid
  private RpsIntermediario intermediario;
  
  @Element(name="ConstrucaoCivil", required = false)
  @Valid
  private RpsDadosContrucaoCivil construcaoCivil;

  @Element(name="RegimeEspecialTributacao", required = false)
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @Element(name="OptanteSimplesNacional")
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @Element(name="IncentivoFiscal")
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
