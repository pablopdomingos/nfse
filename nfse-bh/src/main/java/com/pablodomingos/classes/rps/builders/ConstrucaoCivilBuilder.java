package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsDadosContrucaoCivil;

public class ConstrucaoCivilBuilder extends AbstractBuilder<RpsDadosContrucaoCivil>{
  
  private String codigoObra;
  private String art;
  
  public ConstrucaoCivilBuilder(String codigoObra, String art) {
    this.codigoObra = codigoObra;
    this.art = art;
  }

  @Override
  protected RpsDadosContrucaoCivil buildInternal() {
    return new RpsDadosContrucaoCivil(this);
  }

  public String getCodigoObra() {
    return codigoObra;
  }

  public String getArt() {
    return art;
  }
  
}

