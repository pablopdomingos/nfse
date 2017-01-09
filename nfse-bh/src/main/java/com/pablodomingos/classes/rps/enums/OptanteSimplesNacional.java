package com.pablodomingos.classes.rps.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum OptanteSimplesNacional {

  SIM(1, "Sim"), NAO(2, "Nao");

  private int codigo;
  private String descricao;

  OptanteSimplesNacional(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static OptanteSimplesNacional fromInt(int codigo) {
    if (codigo > 0 && codigo < 2) {
      for (OptanteSimplesNacional optanteSimplesNacional : OptanteSimplesNacional
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
