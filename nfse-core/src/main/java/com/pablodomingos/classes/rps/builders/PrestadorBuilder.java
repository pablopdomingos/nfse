package com.pablodomingos.classes.rps.builders;

public class PrestadorBuilder extends AbstractBuilder {

  private String cpf;
  private String cnpj;
  private String inscricaoMunicipal;
  
  public PrestadorBuilder(String documento) {
    comDocumento(documento);
  }

  public PrestadorBuilder comDocumento(String documento) {
    if (documento.length() == 14) {
      this.cnpj = documento;
    }
    else
    {
      this.cpf = documento;
    }
    return this;
  }

  public PrestadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  public String getCpf() {
    return cpf;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  
}

