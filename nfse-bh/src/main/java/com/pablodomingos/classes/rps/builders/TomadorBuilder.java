package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.classes.rps.RpsTomadorCpfCnpj;
import com.pablodomingos.classes.rps.RpsTomadorEndereco;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacao;

public class TomadorBuilder extends AbstractBuilder<RpsTomador> {

  private RpsTomadorCpfCnpj cpfCnpj;
  RpsTomadorIdentificacao tomadorIdentificacao;
  private String inscricaoMunicipal;
  private String nome;
  private RpsTomadorContato contato;
  private RpsTomadorEndereco endereco;
  
  public TomadorBuilder(String documento) {
    this.cpfCnpj = new TomadorCpfCnpjBuilder()
          .comDocumento(documento).build();
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
    return new RpsTomador(this);
  }

  public RpsTomadorCpfCnpj getTomadorCpfCnpj() {
    return this.cpfCnpj;
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

