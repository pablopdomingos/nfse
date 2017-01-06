package com.pablodomingos.classes.nfse;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeTomadorIdentificacao {

  @XStreamAlias("CpfCnpj")
  private NFSeTomadorCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public NFSeTomadorIdentificacao() {}

  public NFSeTomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public NFSeTomadorIdentificacao comCpfCnpj(NFSeTomadorCpfCnpj cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public NFSeTomadorIdentificacao comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal tomador");
    return this;
  }

}
