package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacao extends AbstractRPS {

  @XStreamAlias("CpfCnpj")
  private RpsCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
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
