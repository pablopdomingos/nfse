package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorEndereco;

public class TomadorEnderecoBuilder extends AbstractBuilder<RpsTomadorEndereco>{

  
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String codigoMunicipio;
  private String uf;
  private String cep;

  public TomadorEnderecoBuilder() {}

  public TomadorEnderecoBuilder comLogradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

  public TomadorEnderecoBuilder comNumeroEndereco(String numero) {
    this.numero = numero;
    return this;
  }

  public TomadorEnderecoBuilder comComplemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

  public TomadorEnderecoBuilder comBairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  public TomadorEnderecoBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
    return this;
  }
  
  public TomadorEnderecoBuilder comUf(String uf) {
    this.uf = uf;
    return this;
  }
  
  public TomadorEnderecoBuilder comCep(String cep) {
    this.cep = cep;
    return this;
  }

  @Override
  protected RpsTomadorEndereco buildInternal() {
    return new RpsTomadorEndereco(this);
  }

  public String getLogradouro() {
    return logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public String getUf() {
    return uf;
  }

  public String getCep() {
    return cep;
  }
}

