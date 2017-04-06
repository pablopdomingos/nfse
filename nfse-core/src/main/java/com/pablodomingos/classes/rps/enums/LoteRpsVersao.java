package com.pablodomingos.classes.rps.enums;

public enum LoteRpsVersao {

  V1_00("1.00"),
  V2_00("2.00"),
  V2_0("2.01"),
  V2_02("2.02"),
  V2_03("2.03");

  LoteRpsVersao(String versao) {
    this.versao = versao;
  }

  public static LoteRpsVersao fromVersao(String versao) {
    for (LoteRpsVersao loteRpsVersao : LoteRpsVersao.values()) {
      if (loteRpsVersao.versao.equals(versao)) {
        return loteRpsVersao;
      }
    }
    return null;
  }

  private String versao;

  @Override
  public String toString() {
    return versao;
  }
}