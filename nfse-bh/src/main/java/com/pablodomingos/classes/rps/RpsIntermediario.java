package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsIntermediario {

  @XStreamAlias("RazaoSocial")
  @NotNull
  private String nome;
  
  @XStreamAlias("CpfCnpj")
  @NotNull
  private RpsIntermediarioCpfCnpj cpfCnpj;
  
  @XStreamAlias("InscricaoMunicipal")
  @Size(min=1, max=15)
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
