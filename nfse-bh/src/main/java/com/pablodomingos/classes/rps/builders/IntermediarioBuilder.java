package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsIntermediario;

public class IntermediarioBuilder extends AbstractBuilder<RpsIntermediario>{

  
  private String documento;
  private String nome;
  private String inscricaoMunicipal;


  public IntermediarioBuilder(String documento, String nome) {
    this.documento = documento;
    this.nome = nome;
  }

  public IntermediarioBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  @Override
  public RpsIntermediario buildInternal() {
    return new RpsIntermediario(this);
  }

  public String getDocumento() {
    return documento;
  }

  public String getNome() {
    return nome;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}

