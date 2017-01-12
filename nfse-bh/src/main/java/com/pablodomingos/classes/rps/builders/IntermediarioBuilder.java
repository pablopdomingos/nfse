package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.classes.rps.RpsIntermediarioCpfCnpj;

public class IntermediarioBuilder extends AbstractBuilder<RpsIntermediario>{

  
  private RpsIntermediarioCpfCnpj cpfCnpj;
  private String nome;
  private String inscricaoMunicipal;


  public IntermediarioBuilder(String documento, String nome) {
    this.cpfCnpj = new IntermediarioCpfCnpjBuilder().comDocumento(documento).build();
    this.nome = nome;
  }

  public IntermediarioBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  @Override
  protected RpsIntermediario buildInternal() {
    return new RpsIntermediario(this);
  }

  public RpsIntermediarioCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public String getNome() {
    return nome;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}

