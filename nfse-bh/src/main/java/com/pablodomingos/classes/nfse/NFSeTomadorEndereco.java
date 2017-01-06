package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.builders.TomadorEnderecoBuilder;
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

  public NFSeTomadorEndereco(TomadorEnderecoBuilder builder){

        this.endereco = builder.getLogradouro();
        this.numero = builder.getNumero();
        this.bairro = builder.getBairro();
        this.complemento = builder.getComplemento();
        this.cep = builder.getCep();
        this.uf = builder.getUf();
        this.codigoMunicipio  = builder.getCodigoMunicipio();
        
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
