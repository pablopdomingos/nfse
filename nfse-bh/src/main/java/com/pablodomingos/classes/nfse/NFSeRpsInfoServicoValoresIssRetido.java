package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoServicoValoresIssRetido {
	
  SIM(1, "Sim"), 
  NAO(2, "N�o");

  private int codigo;
  private String descricao;

  NFSeRpsInfoServicoValoresIssRetido(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NFSeRpsInfoServicoValoresIssRetido fromInt(int codigo) {
    if (codigo > 0 && codigo < 2) {
      for (NFSeRpsInfoServicoValoresIssRetido issRetido : NFSeRpsInfoServicoValoresIssRetido
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
