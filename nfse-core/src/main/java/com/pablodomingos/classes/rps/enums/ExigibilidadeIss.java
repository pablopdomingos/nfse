package com.pablodomingos.classes.rps.enums;

public enum ExigibilidadeIss {

  EXIGIVEL(1, "Exigível"),
  NAO_INCIDENCIA(2, "Não incidência"),
  ISENSAO(3, "Isenção"),
  EXPORTACAO(4, "Exportação"),
  IMUNIDADE(5, "Imunidade"),
  EXIGIBILIDADE_SUSPENSA_JUDICIALMENTE(6, "Exigibilidade suspensa judicialmente"),
  EXIGIBILIDADE_SUSPENSA_ADMINISTRATIVAMENTE(7, "Exigibilidade suspensa administrativamente");

  private int codigo;
  private String descricao;

  ExigibilidadeIss(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static ExigibilidadeIss fromInt(int codigo) {
    for (ExigibilidadeIss naturezaOperacao : ExigibilidadeIss.values()) {
      if (naturezaOperacao.codigo == codigo) {
        return naturezaOperacao;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.valueOf(codigo);
  }

}
