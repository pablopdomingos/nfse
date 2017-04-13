package com.pablodomingos.classes.rps.enums;

public enum ResponsavelRetencao {

  SIM(1, "Tomador"),
  NAO(2, "Intermediário");

  private int codigo;
  private String descricao;

  ResponsavelRetencao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static ResponsavelRetencao fromInt(int codigo) {
    for (ResponsavelRetencao issRetido : ResponsavelRetencao
        .values()) {
      if (issRetido.getCodigo().equals(String.valueOf(codigo))) {
        return issRetido;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }

}
