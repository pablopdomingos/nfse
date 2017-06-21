package com.pablodomingos.classes.rps.enums;

public enum RpsStatus {

  NORMAL(1, "Normal"),
  CANCELADO(2, "Cancelado");

  private final int codigo;
  private final String descricao;

  RpsStatus(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static RpsStatus valueOfCodigo(int codigo) {
    for (RpsStatus status : RpsStatus.values()) {
      if (status.getCodigo() == codigo) {
        return status;
      }
    }
    return null;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }

}
