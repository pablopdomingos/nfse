package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoStatus {
	
  NORMAL(1, "Normal"), 
  CANCELADO(2, "Cancelado");
	
  private final int codigo;
  private final String descricao;

  NFSeRpsInfoStatus(int codigo, String descricao) {
    this.codigo = codigo;
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
