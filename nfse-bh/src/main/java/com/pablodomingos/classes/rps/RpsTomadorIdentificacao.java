package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacao extends AbstractRPS {

  @Element(name="CpfCnpj")
  private RpsTomadorCpfCnpj cpfCnpj;

  @Element(name="InscricaoMunicipal")
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacao(RpsTomadorCpfCnpj cpfCnpj, String inscricaoMunicipal) {
    this.cpfCnpj = cpfCnpj;
    this.inscricaoMunicipal = inscricaoMunicipal;
  }

  public RpsTomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
