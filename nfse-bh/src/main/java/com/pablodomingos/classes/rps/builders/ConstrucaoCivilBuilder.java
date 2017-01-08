package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsDadosContrucaoCivil;
import com.pablodomingos.validadores.ValidadorString;

public class ConstrucaoCivilBuilder {

  private String codigoObra;
  private String art;
  
  public ConstrucaoCivilBuilder(String codigoObra, String art) {
    if (codigoObra == null || art == null) {
      throw new IllegalArgumentException("Codigo da obra ou art não podem ser nulos");
    }
    this.codigoObra = ValidadorString.comTamanhoMaximoEMinimo(15, 1, codigoObra, "Codigo da obra");
    this.art = ValidadorString.comTamanhoMaximoEMinimo(15, 1, art, "art");
  }

  public RpsDadosContrucaoCivil build() {
    return new RpsDadosContrucaoCivil(this);
  }

  public String getCodigoObra() {
    return codigoObra;
  }

  public String getArt() {
    return art;
  }

}

