package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoIncentivadorCultural {

  SIM(1, "Sim"), NAO(2, "N�o");

  private int codigo;
  private String descricao;

  NFSeRpsInfoIncentivadorCultural(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NFSeRpsInfoIncentivadorCultural fromInt(int codigo) {
    if (codigo > 0 && codigo < 2) {
      for (NFSeRpsInfoIncentivadorCultural incentivadorCultural : NFSeRpsInfoIncentivadorCultural
          .values()) {
        if (incentivadorCultural.getCodigo().equals(String.valueOf(codigo))) {
          return incentivadorCultural;
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
