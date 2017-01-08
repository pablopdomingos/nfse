package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorEndereco;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.pablodomingos.validadores.ValidadorString;

public class TomadorEnderecoBuilder{

  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String codigoMunicipio;
  private String uf;
  private String cep;

  public TomadorEnderecoBuilder() {}

  public TomadorEnderecoBuilder comLogradouro(String logradouro) {
    this.logradouro = ValidadorString.comTamanhoMaximoEMinimo(125, 1, logradouro, "Logradouro");
    return this;
  }

  public TomadorEnderecoBuilder comNumeroEndereco(String numero) {
    this.numero = ValidadorString.comTamanhoMaximoEMinimo(10, 1, numero, "Numero do endereco");
    return this;
  }

  public TomadorEnderecoBuilder comComplemento(String complemento) {
    this.complemento = ValidadorString.comTamanhoMaximoEMinimo(60, 1, complemento, "Complemento do endereco");
    return this;
  }

  public TomadorEnderecoBuilder comBairro(String bairro) {
    this.bairro = ValidadorString.comTamanhoMaximoEMinimo(60, 1, bairro, "Bairro");
    return this;
  }

  public TomadorEnderecoBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = ValidadorString.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio");
    return this;
  }

  public TomadorEnderecoBuilder comCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = ValidadorInteiro.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio").toString();
    return this;
  }
  
  public TomadorEnderecoBuilder comUf(String uf) {
    this.uf = ValidadorString.comTamanhoExato(2, uf, "Uf");
    return this;
  }
  
  public TomadorEnderecoBuilder comCep(String cep) {
    this.cep = ValidadorString.comTamanhoExato(8, cep, "Cep");
    return this;
  }

  public RpsTomadorEndereco build() {
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

