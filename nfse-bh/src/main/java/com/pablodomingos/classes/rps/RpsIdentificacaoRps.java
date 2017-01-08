package com.pablodomingos.classes.rps;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.enums.RpsSerie;
import com.pablodomingos.classes.enums.RpsTipo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsIdentificacaoRps {

  @XStreamAlias("Numero")
  @Pattern(regexp = "[^0-9]")
  @Size(min=1, max=15)
  private String numero;

  @XStreamAlias("Serie")
  private RpsSerie serie = RpsSerie.A;

  @XStreamAlias("Tipo")
  private RpsTipo tipo = RpsTipo.RPS;

  public RpsIdentificacaoRps(String numero) {
    this.numero = numero;
  }

  public String getNumero() {
    return numero;
  }

  public RpsSerie getSerie() {
    return serie;
  }

  public void setSerie(RpsSerie serie) {
    this.serie = serie;
  }

  public RpsTipo getTipo() {
    return tipo;
  }

  public void setTipo(RpsTipo tipo) {
    this.tipo = tipo;
  }

}
