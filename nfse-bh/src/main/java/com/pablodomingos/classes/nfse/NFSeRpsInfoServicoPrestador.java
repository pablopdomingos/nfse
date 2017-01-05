package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoPrestador {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public NFSeRpsInfoServicoPrestador() {}

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public void setInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
  }

}
