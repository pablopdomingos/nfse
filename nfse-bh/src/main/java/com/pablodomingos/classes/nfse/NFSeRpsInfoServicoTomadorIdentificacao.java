package com.pablodomingos.classes.nfse;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoTomadorIdentificacao {

  @XStreamAlias("CpfCnpj")
  private NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj cpfCnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public NFSeRpsInfoServicoTomadorIdentificacao() {
    cpfCnpj = new NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj();
  }

  public NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public void setInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal tomador");
  }

}
