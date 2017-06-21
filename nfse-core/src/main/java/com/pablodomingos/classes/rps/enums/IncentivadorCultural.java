package com.pablodomingos.classes.rps.enums;

public enum IncentivadorCultural {

  SIM(1, "Sim"), NAO(2, "Não");

  private int codigo;
  private String descricao;

  IncentivadorCultural(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static IncentivadorCultural fromInt(int codigo) {
    for (IncentivadorCultural incentivadorCultural : IncentivadorCultural
        .values()) {
      if (incentivadorCultural.getCodigo().equals(String.valueOf(codigo))) {
        return incentivadorCultural;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }

}
