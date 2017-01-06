package com.pablodomingos.classes.nfse.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NaturezaOperacao {
	
  TRIBUTACAO_MUNICIPIO(1, "Tributacao no municipio"), 
  TRIBUTACAO_FORA_MUNICIPIO(2, "Tributacao fora do municipio"),
  ISENTO(3, "Isento"),
  IMUNE(4, "Imune"),
  EXIGIBILIDADE_SUSPENSA_JUDICIALMENTE(5, "Exigibilidade suspensa judicialmente"),
  EXIGIBILIDADE_SUSPENSA_ADMINISTRATIVAMENTE(6, "Exigibilidade suspensa administrativamente");
	
  private int codigo;
  private String descricao;

  NaturezaOperacao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NaturezaOperacao fromInt(int codigo) {
    if (codigo > 0 && codigo < 7) {
      for (NaturezaOperacao naturezaOperacao : NaturezaOperacao.values()) {
        if (naturezaOperacao.getCodigo().equals(String.valueOf(codigo))) {
          return naturezaOperacao;
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
