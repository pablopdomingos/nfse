package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.ConstrucaoCivilBuilder;
import org.simpleframework.xml.Element;

public class RpsDadosContrucaoCivil extends AbstractRPS {

  @Element(name="CodigoObra")
  @NotNull
  @Size(min=1, max=15)
  private String codigoObra;

  @Element(name="Art")
  @NotNull
  @Size(min=1, max=15)
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
