package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;
import org.simpleframework.xml.Element;

public class RpsIntermediario extends AbstractRPS {

  @Element(name="RazaoSocial")
  @NotNull
  @Size(min = 1, max = 115)
  private String nome;
  
  @Element(name="CpfCnpj")
  @NotNull
  private RpsIntermediarioCpfCnpj cpfCnpj;
  
  @Element(name="InscricaoMunicipal")
  @Size(min=1, max=15)
  private String inscricaoMunicipal;
  
  public RpsIntermediario(IntermediarioBuilder builder){
    if (builder == null)
      return;
    this.nome = builder.getNome();
    this.cpfCnpj = new RpsIntermediarioCpfCnpj(builder.getCpf(), builder.getCnpj());
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
