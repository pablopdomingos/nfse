package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeTomadorEndereco {

  @XStreamAlias("Endereco")
  private String endereco;

  @XStreamAlias("Numero")
  private String numero;

  @XStreamAlias("Complemento")
  private String complemento;

  @XStreamAlias("Bairro")
  private String bairro;

  @XStreamAlias("CodigoMunicipio")
  private String codigoMunicipio;

  @XStreamAlias("Uf")
  private String uf;

  @XStreamAlias("Cep")
  private String cep;

  public NFSeTomadorEndereco(){}
  
  public String getEndereco() {
    return endereco;
  }

  public NFSeTomadorEndereco comEndereco(String endereco) {
    this.endereco = ValidadorString.comTamanhoMaximoEMinimo(125, 1, StringUtil.removeAcentos(endereco), "Endereco");
    return this;
  }

  public String getNumero() {
    return numero;
  }

  public NFSeTomadorEndereco comNumero(String numero) {
    this.numero = ValidadorString.comTamanhoMaximoEMinimo(10, 1, StringUtil.removeAcentos(numero), "Numero do Endereco");
    return this;
  }

  public String getComplemento() {
    if (complemento == null || complemento.isEmpty()) {
      return "";
    }
    return complemento;
  }

  public NFSeTomadorEndereco comComplemento(String complemento) {
    this.complemento = ValidadorString.comTamanhoMaximoEMinimo(60, 1, StringUtil.removeAcentos(complemento), "Complemento");
    return this;
  }

  public String getBairro() {
    return bairro;
  }

  public NFSeTomadorEndereco comBairro(String bairro) {
    this.bairro = ValidadorString.comTamanhoMaximoEMinimo(60, 1, StringUtil.removeAcentos(bairro), "Bairro");
    return this;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public NFSeTomadorEndereco comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = ValidadorString.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio");
    return this;
  }
  
  public String getUf() {
    return uf;
  }

  public NFSeTomadorEndereco comUf(String uf) {
    this.uf = ValidadorString.comTamanhoExato(2, uf, "UF");
    return this;
  }

  public String getCep() {
    return cep;
  }

  public NFSeTomadorEndereco comCep(String cep) {
    this.cep = ValidadorString.comTamanhoExato(8, cep, "CEP");
    return this;
  }

}
