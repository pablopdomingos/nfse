package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsIntermediario {

  @XStreamAlias("RazaoSocial")
  private String nome;
  
  @XStreamAlias("CpfCnpj")
  private RpsIntermediarioCpfCnpj cpfCnpj;
  
  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;
  
  public RpsIntermediario(IntermediarioBuilder builder){
    
    this.nome = builder.getNome();
    this.cpfCnpj = new RpsIntermediarioCpfCnpj(builder.getDocumento());
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();

  }

  public String getNome() {
    return nome;
  }

  public RpsIntermediarioCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }
  
}
