package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Tomador {

  @XStreamAlias("IdentificacaoTomador")
  private TomadorIdentificacao identificacaoTomador;
  
  @XStreamAlias("RazaoSocial")
  private String nome;
  
  @XStreamAlias("Endereco")
  private TomadorEndereco endereco;
  
  @XStreamAlias("Contato")
  private TomadorContato contato;

  public Tomador() {}

  public TomadorEndereco getEndereco() {
    return endereco;
  }

  public Tomador comEndereco(TomadorEndereco endereco) {
    this.endereco = endereco;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public Tomador comNome(String razaoSocial) {
    this.nome = StringUtil.removeAcentos(razaoSocial);
    return this;
  }

  public TomadorIdentificacao getIdentificacaoTomador() {
    return identificacaoTomador;
  }

  public Tomador comIdentificacaoTomador(TomadorIdentificacao identificacaoTomador) {
    this.identificacaoTomador = identificacaoTomador;
    return this;
  }

  public TomadorContato getContato() {
    return contato;
  }

  public Tomador comContato(TomadorContato contato) {
    this.contato = contato;
    return this;
  }

}
