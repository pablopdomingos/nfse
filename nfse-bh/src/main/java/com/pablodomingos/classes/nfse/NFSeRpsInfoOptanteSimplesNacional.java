package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoOptanteSimplesNacional {

  SIM(1, "Sim"), NAO(2, "N�o");

  private int codigo;
  private String descricao;

  NFSeRpsInfoOptanteSimplesNacional(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NFSeRpsInfoOptanteSimplesNacional fromInt(int codigo) {
    if (codigo > 0 && codigo < 2) {
      for (NFSeRpsInfoOptanteSimplesNacional optanteSimplesNacional : NFSeRpsInfoOptanteSimplesNacional
          .values()) {
        if (optanteSimplesNacional.getCodigo().equals(String.valueOf(codigo))) {
          return optanteSimplesNacional;
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
