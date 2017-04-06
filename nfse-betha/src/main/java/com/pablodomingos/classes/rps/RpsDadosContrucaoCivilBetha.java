package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ConstrucaoCivilBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsDadosContrucaoCivilBetha extends AbstractRPS {

  @Element(name="CodigoObra")
  @NotNull
  @Size(min=1, max=15)
  private String codigoObra;

  @Element(name="Art")
  @NotNull
  @Size(min=1, max=15)
  private String art;

  public RpsDadosContrucaoCivilBetha(ConstrucaoCivilBuilder builder) {
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
