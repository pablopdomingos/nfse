package com.pablodomingos.classes.rps;

import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.TomadorIdentificacaoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorIdentificacao {

  @XStreamAlias("CpfCnpj")
  private RpsTomadorCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  public RpsTomadorIdentificacao(TomadorIdentificacaoBuilder builder) {
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
    this.cpfCnpj = builder.getCpfCnpj();
  }

  public RpsTomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
