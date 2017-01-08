package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ConstrucaoCivilBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsDadosContrucaoCivil {

  @XStreamAlias("CodigoObra")
  private String codigoObra;

  @XStreamAlias("Art")
  private String art;

  public RpsDadosContrucaoCivil(ConstrucaoCivilBuilder builder) {
    this.codigoObra = builder.getCodigoObra();
    this.art = builder.getArt();
  }

  public String getCodigoObra() {
    return codigoObra;
  }

  public String getArt() {
    return art;
  }

}
