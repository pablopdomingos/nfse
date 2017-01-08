package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsPrestador {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public RpsPrestador(PrestadorBuilder builder) {
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
