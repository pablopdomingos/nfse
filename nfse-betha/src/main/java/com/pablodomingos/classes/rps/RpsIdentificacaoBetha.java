package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsTipo;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsIdentificacaoBetha extends AbstractRPS {

  @Element(name="Numero", required = false)
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=15)
  private String numero;

  @Element(name="Serie", required = false)
  @NotNull
  private String serie;

  @Element(name="Tipo", required = false)
  @NotNull
  private RpsTipo tipo = RpsTipo.RPS;

  public RpsIdentificacaoBetha() {
  }

  public RpsIdentificacaoBetha(String numero) {
    this.numero = numero;
  }

  public RpsIdentificacaoBetha(String numero, String serie) {
    this.numero = numero;
    if (serie != null)
      this.serie = serie;
  }

  public String getNumero() {
    return numero;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public RpsTipo getTipo() {
    return tipo;
  }

  public void setTipo(RpsTipo tipo) {
    this.tipo = tipo;
  }

}
