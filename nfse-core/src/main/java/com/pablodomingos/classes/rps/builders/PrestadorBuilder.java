package com.pablodomingos.classes.rps.builders;

public class PrestadorBuilder extends AbstractBuilder {

  private String cnpj;
  private String inscricaoMunicipal;
  
  public PrestadorBuilder(String cnpj) {
    this.cnpj = cnpj;
  }

  public PrestadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  
}

