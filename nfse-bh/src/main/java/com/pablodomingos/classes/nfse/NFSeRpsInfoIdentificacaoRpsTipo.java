package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoIdentificacaoRpsTipo {

  RPS(1, "Rps"), MISTA(2, "Mista"), CUPOM(3, "Cupom");

  private int codigo;
  private String descricao;

  NFSeRpsInfoIdentificacaoRpsTipo(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }
  
  public String getDescricao() {
    return this.descricao;
  }

  public static NFSeRpsInfoIdentificacaoRpsTipo fromInt(int codigo) {
    if (codigo > 0 && codigo < 4) {
      for (NFSeRpsInfoIdentificacaoRpsTipo tipo : NFSeRpsInfoIdentificacaoRpsTipo.values()) {
        if (tipo.getCodigo().equals(String.valueOf(codigo))) {
          return tipo;
        }
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }
}
