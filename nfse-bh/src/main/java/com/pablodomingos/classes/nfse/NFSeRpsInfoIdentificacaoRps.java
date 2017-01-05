package com.pablodomingos.classes.nfse;

import java.math.BigInteger;

import com.pablodomingos.validadores.ValidadorInteiro;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoIdentificacaoRps {

  @XStreamAlias("Numero")
  private BigInteger numero;

  @XStreamAlias("Serie")
  private NFSeRpsInfoIdentificacaoRpsSerie serie;

  @XStreamAlias("Tipo")
  private NFSeRpsInfoIdentificacaoRpsTipo tipo;

  public NFSeRpsInfoIdentificacaoRps() {
    serie = NFSeRpsInfoIdentificacaoRpsSerie.NFE;
    tipo = NFSeRpsInfoIdentificacaoRpsTipo.RPS;
  }

  public BigInteger getNumero() {
    return numero;
  }

  public void setNumero(BigInteger numero) {
    this.numero = ValidadorInteiro.comTamanhoMaximo(15, numero, "Numero de identificação RPS");
  }

  public NFSeRpsInfoIdentificacaoRpsSerie getSerie() {
    return serie;
  }

  public void setSerie(NFSeRpsInfoIdentificacaoRpsSerie serie) {
    this.serie = serie;
  }

  public NFSeRpsInfoIdentificacaoRpsTipo getTipo() {
    return tipo;
  }

  public void setTipo(NFSeRpsInfoIdentificacaoRpsTipo tipo) {
    this.tipo = tipo;
  }


}
