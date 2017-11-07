package com.pablodomingos.classes.rps.servicos;


import com.thoughtworks.xstream.annotations.XStreamAlias;

public class OrgaoGerador {

  @XStreamAlias("CodigoMunicipio")
  private String codigoMunicipio;

  @XStreamAlias("Uf")
  private String uf;

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public void setCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }
}
