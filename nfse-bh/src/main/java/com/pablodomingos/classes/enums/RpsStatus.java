package com.pablodomingos.classes.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum RpsStatus {
	
  NORMAL(1, "Normal"), 
  CANCELADO(2, "Cancelado");
	
  private final int codigo;
  private final String descricao;

  RpsStatus(int codigo, String descricao) {
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
