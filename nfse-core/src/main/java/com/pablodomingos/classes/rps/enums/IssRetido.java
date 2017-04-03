package com.pablodomingos.classes.rps.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum IssRetido {
	
  SIM(1, "Sim"), 
  NAO(2, "Não");

  private int codigo;
  private String descricao;

  IssRetido(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static IssRetido fromInt(int codigo) {
    if (codigo > 0 && codigo < 2) {
      for (IssRetido issRetido : IssRetido
          .values()) {
        if (issRetido.getCodigo().equals(String.valueOf(codigo))) {
          return issRetido;
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
