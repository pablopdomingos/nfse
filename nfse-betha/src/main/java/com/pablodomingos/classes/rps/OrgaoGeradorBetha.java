package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.UfEstados;
import org.simpleframework.xml.Element;

public class OrgaoGeradorBetha {
  @Element(name="CodigoMunicipio", required = false)
  private String codigoMunicipio;

  @Element(name="Uf", required = false)
  private UfEstados uf;

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public UfEstados getUf() {
    return uf;
  }
}
