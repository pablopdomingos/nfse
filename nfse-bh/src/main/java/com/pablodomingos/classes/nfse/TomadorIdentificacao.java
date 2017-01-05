package com.pablodomingos.classes.nfse;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TomadorIdentificacao {

  @XStreamAlias("CpfCnpj")
  private TomadorCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public TomadorIdentificacao() {}

  public TomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public TomadorIdentificacao comCpfCnpj(TomadorCpfCnpj cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public TomadorIdentificacao comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal tomador");
    return this;
  }

}
