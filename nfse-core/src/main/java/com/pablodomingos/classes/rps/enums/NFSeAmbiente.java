package com.pablodomingos.classes.rps.enums;

public enum NFSeAmbiente {

  HOMOLOGACAO(1, "Homolocacao"), 
  PRODUCAO(2, "Producao"); 

  private int codigo;
  private String descricao;

  NFSeAmbiente(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }
  
  public String getDescricao() {
    return this.descricao;
  }

  public static NFSeAmbiente fromInt(int codigo) {
    if (codigo > 1 && codigo < 2) {
      for (NFSeAmbiente tipo : NFSeAmbiente.values()) {
        if (tipo.getCodigo().equals(String.valueOf(codigo))) {
          return tipo;
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
