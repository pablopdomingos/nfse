package com.pablodomingos.classes.rps.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum CodigoCancelamento {
  //Bh nao aceita cancelar via webservice NFSe com erro na emissao
  //ERRO_NA_EMISSAO(1, "Erro na emissao"),
  SERVICO_NAO_CONCLUIDO(2, "Servico cao concluido");

  private int codigo;
  private String descricao;

  CodigoCancelamento(int cod, String descricao) {
    this.codigo = cod;
    this.descricao = descricao;
  }
  
  public String getDescricao() {
    return this.descricao;
  }
  
  @Override
  public String toString() {
    return String.valueOf(codigo);
  }
    

}
