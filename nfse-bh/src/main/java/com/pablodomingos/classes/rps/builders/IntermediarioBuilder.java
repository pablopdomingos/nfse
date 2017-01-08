package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.validadores.ValidadorString;

public class IntermediarioBuilder {

  private String documento;
  private String nome;
  private String inscricaoMunicipal;


  public IntermediarioBuilder(String documento, String nome) {
    if (documento == null || nome == null) {
      throw new IllegalArgumentException("Documento não pode ser nulo");
    }
    this.documento = documento;
    this.nome = ValidadorString.comTamanhoMaximoEMinimo(115, 1, nome, "Nome Intermadiario");
  }

  public IntermediarioBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal do intermadiario");
    return this;
  }
  
  public RpsIntermediario build() {
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

