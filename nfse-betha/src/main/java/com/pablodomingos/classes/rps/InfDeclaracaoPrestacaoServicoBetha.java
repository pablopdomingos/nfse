package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import java.time.LocalDate;

public class InfDeclaracaoPrestacaoServicoBetha {

  @Element(name="Rps", required = false)
  private RpsBetha rps;


  @Element(name="Competencia", required = false)
  private LocalDate competencia;


  @Element(name="Servico", required = false)
  private RpsServicoBetha servico;


  @Element(name="Prestador", required = false)
  private RpsPrestadorBetha prestador;


  @Element(name="Tomador", required = false)
  private RpsTomadorBetha tomador;


  @Element(name="OptanteSimplesNacional", required = false)
  private String optanteSimplesNacional;


  @Element(name="IncentivoFiscal", required = false)
  private String incentivoFiscal;

  public RpsBetha getRps() {
    return rps;
  }

  public LocalDate getCompetencia() {
    return competencia;
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

  public String getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public String getIncentivoFiscal() {
    return incentivoFiscal;
  }
}
