package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RpsInfoBetha extends AbstractRPS {

  @Attribute(name = "Id", required = false)
  @NotNull
  @Size(min = 1, max = 255)
  private String id;

  @Element(name = "Rps", required = false)
  @NotNull
  @Valid
  private RpsInfoIdentificacaoBetha rps;

  @Element(name = "Competencia", required = false)
  @NotNull
  private LocalDate competencia;

  @Element(name = "RpsSubstituido", required = false)
  @Valid
  private RpsIdentificacaoBetha rpsSubstituido;

  @Element(name = "Servico", required = false)
  @NotNull
  @Valid
  private RpsServicoBetha servico;

  @Element(name = "Prestador", required = false)
  @NotNull
  @Valid
  private RpsPrestadorBetha prestador;

  @Element(name = "Tomador", required = false)
  @Valid
  private RpsTomadorBetha tomador;

  @Element(name = "IntermediarioServico", required = false)
  @Valid
  private RpsIntermediarioBetha intermediario;

  @Element(name = "ConstrucaoCivil", required = false)
  @Valid
  private RpsDadosContrucaoCivilBetha construcaoCivil;

  @Element(name = "RegimeEspecialTributacao", required = false)
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @Element(name = "OptanteSimplesNacional", required = false)
  @NotNull
  private OptanteSimplesNacional optanteSimplesNacional;

  @Element(name = "IncentivoFiscal", required = false)
  @NotNull
  private IncentivadorCultural incentivadorCultural;

  public RpsInfoBetha() {
  }

  public RpsInfoBetha(RpsInfoBuilder builder) {
    competencia = LocalDate.now();
    id = builder.getId();
    rps = new RpsInfoIdentificacaoBetha(
        new RpsIdentificacaoBetha(builder.getId(), builder.getSerie()),
        builder.getDataEmissao().toLocalDate(),
        builder.getStatus()
    );
    if (builder.getContrucaoCivil() != null)
      construcaoCivil = new RpsDadosContrucaoCivilBetha(builder.getContrucaoCivil());
    regimeEspecialTributacao = builder.getRegimeEspecialTributacao();
    optanteSimplesNacional = builder.getOptanteSimplesNacional();
    incentivadorCultural = builder.getIncentivadorCultural();
    servico = new RpsServicoBetha(builder.getServico());
    prestador = new RpsPrestadorBetha(builder.getPrestador());
    tomador = new RpsTomadorBetha(builder.getTomador());
    if (builder.getIntermediario() != null)
      intermediario = new RpsIntermediarioBetha(builder.getIntermediario());
    if (builder.getIdSubstituido() != null && builder.getSerieSubstituido() != null)
      rpsSubstituido = new RpsIdentificacaoBetha(builder.getIdSubstituido(), builder.getSerieSubstituido());
  }

  public String getId() {
    return id;
  }

  public RpsServicoBetha getServico() {
    return servico;
  }

  public RpsPrestadorBetha getPrestador() {
    return prestador;
  }

  public RpsTomadorBetha getTomador() {
    return tomador;
  }

  public RpsIntermediarioBetha getIntermediario() {
    return intermediario;
  }

  public RpsIdentificacaoBetha getRpsSubstituido() {
    return rpsSubstituido;
  }

  public RpsDadosContrucaoCivilBetha getConstrucaoCivil() {
    return construcaoCivil;
  }

  public RpsInfoIdentificacaoBetha getRps() {
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
