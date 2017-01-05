package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum NFSeRpsInfoNaturezaOperacao {
	
  TRIBUTACAO_MUNICIPIO(1, "Tributa��o no munic�pio"), 
  TRIBUTACAO_FORA_MUNICIPIO(2, "Tributa��o fora do munic�pio"),
  ISENTO(3, "Isento"),
  IMUNE(4, "Imune"),
  EXIGIBILIDADE_SUSPENSA_JUDICIALMENTE(5, "Exigibilidade suspensa judicialmente"),
  EXIGIBILIDADE_SUSPENSA_ADMINISTRATIVAMENTE(6, "Exigibilidade suspensa administrativamente");
	
  private int codigo;
  private String descricao;

  NFSeRpsInfoNaturezaOperacao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public String getCodigo() {
    return String.valueOf(this.codigo);
  }

  public String getDescricao() {
    return this.descricao;
  }
  
  public static NFSeRpsInfoNaturezaOperacao fromInt(int codigo) {
    if (codigo > 0 && codigo < 7) {
      for (NFSeRpsInfoNaturezaOperacao naturezaOperacao : NFSeRpsInfoNaturezaOperacao.values()) {
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
