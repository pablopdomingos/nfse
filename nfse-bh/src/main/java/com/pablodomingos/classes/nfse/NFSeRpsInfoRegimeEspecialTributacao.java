package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoRegimeEspecialTributacao {
	
  MICRO_EMPRESA_MUNICIPAL(1, "Micro empresa municipal"), 
  ESTIMATIVA(2, "Estimativa"),
  SOCIEDADE_PROFISSIONAIS(3, "Sociedade profissional"),
  COOPERATIVA(4, "Cooperativa"),
  MEI(5, "Microempreendedor individual"),
  ME_EPP_SIMPLES_NACIONAL(6, "Microempres�rio e empresa de pequeno porte");
	
  private int codigo;
  private String descricao;

  NFSeRpsInfoRegimeEspecialTributacao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NFSeRpsInfoRegimeEspecialTributacao fromInt(int codigo) {
    if (codigo > 0 && codigo < 7) {
      for (NFSeRpsInfoRegimeEspecialTributacao regimeEspecialTributacao : NFSeRpsInfoRegimeEspecialTributacao
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
