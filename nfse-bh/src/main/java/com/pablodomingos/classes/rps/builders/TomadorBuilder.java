package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.classes.rps.RpsTomadorEndereco;
import com.pablodomingos.validadores.ValidadorString;

public class TomadorBuilder{

  private String documento;
  private String inscricaoMunicipal;
  private String nome;
  private RpsTomadorContato contato;
  private RpsTomadorEndereco endereco;
  
  public TomadorBuilder(String documento) {
    if (documento == null) {
      throw new IllegalArgumentException("Documento não pode ser nulo");
    }
    this.documento = documento;
  }

  public TomadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal");
    return this;
  }

  public TomadorBuilder comNome(String nome) {
    this.nome = ValidadorString.comTamanhoMaximoEMinimo(115, 1, nome, "Nome Tomador");
    return this;
  }

  public TomadorBuilder comContato(RpsTomadorContato contato) {
    this.contato = contato;
    return this;
  }
  
  public TomadorBuilder comEndereco(RpsTomadorEndereco endereco){
    this.endereco = endereco;
    return this;
  }
  
  public TomadorBuilder comEndereco(TomadorEnderecoBuilder endereco){
    this.endereco = new RpsTomadorEndereco(endereco);
    return this;
  }
  
  public RpsTomador build() {
    return new RpsTomador(this);
  }

  public String getDocumento() {
    return documento;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public String getNome() {
    return nome;
  }
  
  public RpsTomadorContato getContato() {
    return contato;
  }

  public RpsTomadorEndereco getEndereco() {
    return endereco;
  }
  
}

