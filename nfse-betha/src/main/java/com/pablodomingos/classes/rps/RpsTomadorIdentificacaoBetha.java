package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacaoBetha extends AbstractRPS {

  @Element(name="CpfCnpj", required = false)
  private RpsCpfCnpjBetha cpfCnpj;

  @Element(name="InscricaoMunicipal", required = false)
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacaoBetha() {
  }

  public RpsTomadorIdentificacaoBetha(RpsCpfCnpjBetha cpfCnpj, String inscricaoMunicipal) {
    this.cpfCnpj = cpfCnpj;
    this.inscricaoMunicipal = inscricaoMunicipal;
  }

  public RpsCpfCnpjBetha getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
