package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacao extends AbstractRPS {

  @XStreamAlias("CpfCnpj")
  private RpsTomadorCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
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
