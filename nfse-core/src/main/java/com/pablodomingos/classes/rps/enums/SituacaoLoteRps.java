package com.pablodomingos.classes.rps.enums;

public enum SituacaoLoteRps {

  NAO_RECEBIDO(1, "Não Recebido"),
  NAO_PROCESSADO(2, "Não Processado"),
  PROCESSADO_COM_ERRO(3, "Processado com Erro"),
  PROCESSADO_COM_SUCESSO(4, "Processado com Sucesso");

  private final int codigo;
  private final String descricao;

  SituacaoLoteRps(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static SituacaoLoteRps fromInt(int codigo) {
    for (SituacaoLoteRps status : SituacaoLoteRps.values()) {
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
    return descricao;
  }

  @Override
  public String toString() {
    return descricao;
  }

}
