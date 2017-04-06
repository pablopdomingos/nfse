package com.pablodomingos.classes.rps.enums;

public enum  CodigoCancelamento {
  //Bh nao aceita cancelar via webservice NFSe com erro na emissao //fixme
  ERRO_NA_EMISSAO(1, "Erro na emissao"),
  SERVICO_NAO_CONCLUIDO(2, "Servico nao concluido");

  int codigo;
  String descricao;

  CodigoCancelamento(int cod, String descricao) {
    this.codigo = cod;
    this.descricao = descricao;
  };

  public static CodigoCancelamento fromInt(int codigo) {
    for (CodigoCancelamento codigoCancelamento : CodigoCancelamento.values()) {
      if (codigoCancelamento.codigo == codigo) {
        return codigoCancelamento;
      }
    }
    return null;
  }

  public String getDescricao() {
    return this.descricao;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }


}
