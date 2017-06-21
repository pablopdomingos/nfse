package com.pablodomingos.classes.rps.builders;

public class ConstrucaoCivilBuilder extends AbstractBuilder {
  
  private String codigoObra;
  private String art;
  
  public ConstrucaoCivilBuilder(String codigoObra, String art) {
    this.codigoObra = codigoObra;
    this.art = art;
  }

  public String getCodigoObra() {
    return codigoObra;
  }

  public String getArt() {
    return art;
  }
  
}

