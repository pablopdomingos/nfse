package com.pablodomingos.classes.rps.enums;

public enum RegimeEspecialTributacao {
	
  MICRO_EMPRESA_MUNICIPAL(1, "Microempresa Municipal"), 
  ESTIMATIVA(2, "Estimativa"),
  SOCIEDADE_PROFISSIONAIS(3, "Sociedade de Profissionais"),
  COOPERATIVA(4, "Cooperativa"),
  MEI(5, "Microempresario Individual (MEI)"),
  ME_EPP_SIMPLES_NACIONAL(6, "Microempresario e Empresa de Pequeno Porte (ME EPP)");
	
  private int codigo;
  private String descricao;

  RegimeEspecialTributacao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static RegimeEspecialTributacao fromInt(int codigo) {
    if (codigo > 0 && codigo < 7) {
      for (RegimeEspecialTributacao regimeEspecialTributacao : RegimeEspecialTributacao
          .values()) {
        if (regimeEspecialTributacao.getCodigo().equals(String.valueOf(codigo))) {
          return regimeEspecialTributacao;
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
