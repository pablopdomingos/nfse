package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacao extends AbstractRPS {

  @Element(name="CpfCnpj", required = false)
  private RpsCpfCnpj cpfCnpj;

  @Element(name="InscricaoMunicipal", required = false)
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacao(RpsCpfCnpj cpfCnpj, String inscricaoMunicipal) {
    this.cpfCnpj = cpfCnpj;
    this.inscricaoMunicipal = inscricaoMunicipal;
  }

  public RpsCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
