package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsPrestador;

public class PrestadorBuilder extends AbstractBuilder<RpsPrestador>{

  private String cnpj;
  private String inscricaoMunicipal;
  
  public PrestadorBuilder(String cnpj) {
    this.cnpj = cnpj;
  }

  public PrestadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  @Override
  public RpsPrestador buildInternal() {
    return new RpsPrestador(this);
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  
}

