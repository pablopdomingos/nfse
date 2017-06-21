package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.Size;

public class RpsTomadorIdentificacaoBH extends AbstractRPS {

  @Element(name="CpfCnpj", required = false)
  private RpsTomadorCpfCnpjBH cpfCnpj;

  @Element(name="InscricaoMunicipal", required = false)
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacaoBH(RpsTomadorCpfCnpjBH cpfCnpj, String inscricaoMunicipal) {
    this.cpfCnpj = cpfCnpj;
    this.inscricaoMunicipal = inscricaoMunicipal;
  }

  public RpsTomadorCpfCnpjBH getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
