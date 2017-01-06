package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.enums.RpsSerie;
import com.pablodomingos.classes.nfse.enums.RpsTipo;
import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoIdentificacaoRps {

  @XStreamAlias("Numero")
  private String numero;

  @XStreamAlias("Serie")
  private RpsSerie serie = RpsSerie.A;

  @XStreamAlias("Tipo")
  private RpsTipo tipo = RpsTipo.RPS;

  public NFSeRpsInfoIdentificacaoRps(String numero) {
    this.numero = ValidadorString.comTamanhoMaximo(15, numero, "Numero de identificacao RPS");
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
