package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.builders.PrestadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSePrestador {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public NFSePrestador(PrestadorBuilder builder) {
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
