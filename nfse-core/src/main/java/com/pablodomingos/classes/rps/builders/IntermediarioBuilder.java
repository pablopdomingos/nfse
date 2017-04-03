package com.pablodomingos.classes.rps.builders;

public class IntermediarioBuilder extends AbstractBuilder {

  private String nome;
  private String inscricaoMunicipal;
  private String cpf;
  private String cnpj;

  public IntermediarioBuilder(String documento, String nome) {
    comDocumento(documento);
    this.nome = nome;
  }

  public IntermediarioBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  public IntermediarioBuilder comDocumento(String documento) {
    if(documento.length() == 11){
      this.cpf = documento;
    }else{
      this.cnpj = documento;
    }
    return this;
  }

  public String getCpf() {
    return cpf;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getNome() {
    return nome;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}

