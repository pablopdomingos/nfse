package com.pablodomingos.classes.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum UfEstados {

  AC("AC", "Acre"),
  AL("AL", "Alagoas"),
  AM("AM", "Amazonas"),
  AP("AP", "Amapa"),
  BA("BA", "Bahia"),
  CE("CE", "Ceara"),
  DF("DF", "Distrito Federal"),
  ES("ES", "Espirito Santo"),
  GO("GO", "Goias"),
  MA("MA", "Maranhao"),
  MG("MG", "Minas Gerais"),
  MS("MS", "Mato Grosso do Sul"),
  MT("MT", "Mato Grosso"),
  PA("PA", "Para"),
  PB("PB", "Paraiba"),
  PE("PE", "Pernambuco"),
  PI("PI", "Piaui"),
  PR("PR", "Parana"),
  RJ("RJ", "Rio de Janeiro"),
  RN("RN", "Rio Grande do Norte"),
  RO("RO", "Rondonia"),
  RR("RR", "Roraima"),
  RS("RS", "Rio Grande do Sul"),
  SC("SC", "Santa Catarina"),
  SE("SE", "Sergipe"),
  SP("SP", "Sao Paulo"),
  TO("TO", "Tocantins");

  private String uf;
  private String nome;

  UfEstados(String uf, String descricao) {
    this.uf = uf;
    this.nome = descricao;
  }

  public String getUf() {
    return this.uf;
  }

  public String getNomeUf() {
    return this.nome;
  }
  
  public static UfEstados fromInt(String uf) {
      for (UfEstados ufEstado : UfEstados.values()) {
        if (ufEstado.getUf().equals(String.valueOf(uf))) {
          return ufEstado;
        }
      }
    
    return null;
  }

  @Override
  public String toString() {
    return this.uf;
  }

}
