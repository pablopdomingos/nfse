package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoTomadorEndereco {

  @XStreamAlias("Endereco")
  private String endereco;

  @XStreamAlias("Numero")
  private String numero;

  @XStreamAlias("Complemento")
  private String complemento;

  @XStreamAlias("Bairro")
  private String bairro;

  @XStreamAlias("CodigoMunicipio")
  private Integer codigoMunicipio;

  @XStreamAlias("Uf")
  private String uf;

  @XStreamAlias("Cep")
  private String cep;

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = StringUtil.removeAcentos(endereco);
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = StringUtil.removeAcentos(numero);
  }

  public String getComplemento() {
    if (complemento == null || complemento.isEmpty()) {
      return null;
    }
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = StringUtil.removeAcentos(complemento);
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = StringUtil.removeAcentos(bairro);
  }

  public Integer getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public void setCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

}
