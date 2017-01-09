package com.pablodomingos.classes.rps.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum RpsTipo {

  RPS(1, "Recibo Provisorio de Servicos"), 
  MISTA(2, "RPS Nota Fiscal Conjugada (Mista)"), 
  CUPOM(3, "Cupom");

  private int codigo;
  private String descricao;

  RpsTipo(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }
  
  public String getDescricao() {
    return this.descricao;
  }

  public static RpsTipo fromInt(int codigo) {
    if (codigo > 0 && codigo < 4) {
      for (RpsTipo tipo : RpsTipo.values()) {
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
