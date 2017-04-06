package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsTomadorEndereco extends AbstractRPS {

  @Element(name="Endereco")
  @NotNull
  @Size(min=1, max=125)
  private String endereco;

  @Element(name="Numero")
  @NotNull
  @Size(min=1, max=10)
  private String numero;

  @Element(name="Complemento")
  @Size(min=1, max=60)
  private String complemento;

  @Element(name="Bairro")
  @NotNull
  @Size(min=1, max=60)
  private String bairro;

  @Element(name="CodigoMunicipio")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=7)
  private String codigoMunicipio;

  @Element(name="Uf")
  @NotNull
  @Size(min=2, max=2)
  private String uf;

  @Element(name="Cep")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=8, max=8)
  private String cep;

  public RpsTomadorEndereco(String endereco, String numero, String complemento, String bairro, String codigoMunicipio, String uf, String cep) {
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.codigoMunicipio = codigoMunicipio;
    this.uf = uf;
    this.cep = cep;
  }
  
  public String getEndereco() {
    return endereco;
  }

  public String getNumero() {
    return numero;
  }

  public String getComplemento() {
    if (complemento == null || complemento.isEmpty()) {
      return "";
    }
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
