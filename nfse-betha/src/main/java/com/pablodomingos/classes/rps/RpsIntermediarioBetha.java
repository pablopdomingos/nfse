package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsIntermediarioBetha extends AbstractRPS {

  @Element(name="RazaoSocial")
  @NotNull
  @Size(min = 1, max = 115)
  private String nome;
  
  @Element(name="CpfCnpj")
  @NotNull
  private RpsCpfCnpjBetha cpfCnpj;
  
  @Element(name="InscricaoMunicipal")
  @Size(min=1, max=15)
  private String inscricaoMunicipal;
  
  public RpsIntermediarioBetha(IntermediarioBuilder builder){
    if (builder == null)
      return;
    this.nome = builder.getNome();
    this.cpfCnpj = new RpsCpfCnpjBetha(builder.getCpf(), builder.getCnpj());
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
  }

  public String getNome() {
    return nome;
  }

  public RpsCpfCnpjBetha getCpfCnpj() {
    return cpfCnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }
  
}