package com.pablodomingos.classes.rps;

import javax.validation.constraints.Size;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorIdentificacao {

  @XStreamAlias("CpfCnpj")
  private RpsTomadorCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacao() {}

  public RpsTomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public RpsTomadorIdentificacao comCpfCnpj(RpsTomadorCpfCnpj cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public RpsTomadorIdentificacao comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

}
