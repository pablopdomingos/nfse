package com.pablodomingos.classes.rps;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsPrestador {

  @XStreamAlias("Cnpj")
  @CNPJ
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  @Size(min=1, max=15)
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
