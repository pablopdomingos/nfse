package com.pablodomingos.classes.nfse;

import java.math.BigInteger;

import com.pablodomingos.classes.nfse.enums.RpsSerie;
import com.pablodomingos.classes.nfse.enums.RpsTipo;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoIdentificacaoRps {

  @XStreamAlias("Numero")
  private BigInteger numero;

  @XStreamAlias("Serie")
  private RpsSerie serie = RpsSerie.NFE;

  @XStreamAlias("Tipo")
  private RpsTipo tipo = RpsTipo.RPS;

  public NFSeRpsInfoIdentificacaoRps() {}

  public BigInteger getNumero() {
    return numero;
  }

  public NFSeRpsInfoIdentificacaoRps comNumero(BigInteger numero) {
    this.numero = ValidadorInteiro.comTamanhoMaximo(15, numero, "Numero de identificacao RPS");
    return this;
  }

  public RpsSerie getSerie() {
    return serie;
  }

  public NFSeRpsInfoIdentificacaoRps comSerie(RpsSerie serie) {
    this.serie = serie;
    return this;
  }

  public RpsTipo getTipo() {
    return tipo;
  }

  public NFSeRpsInfoIdentificacaoRps comTipo(RpsTipo tipo) {
    this.tipo = tipo;
    return this;
  }

}
