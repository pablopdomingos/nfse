package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.classes.rps.RpsTomadorEndereco;

public class TomadorBuilder extends AbstractBuilder<RpsTomador> {

  private String documento;
  private String inscricaoMunicipal;
  private String nome;
  private RpsTomadorContato contato;
  private RpsTomadorEndereco endereco;
  
  public TomadorBuilder(String documento) {
    this.documento = documento;
  }

  public TomadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  public TomadorBuilder comNome(String nome) {
    this.nome = nome;
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
  
  @Override
  protected RpsTomador buildInternal() {
    RpsTomador tomador = new RpsTomador(this);
  
    return tomador;
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

