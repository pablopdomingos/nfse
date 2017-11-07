package com.pablodomingos.assinatura;

public enum TipoCertificado {
  A1, A3_TOKEN("Token.cfg"), A3_CARD("SmartCard.cfg");

  private String arquivoConfiguracao;

  TipoCertificado() {

  }

  TipoCertificado(String arquivoConfiguracao) {
    this.arquivoConfiguracao = arquivoConfiguracao;
  }

  public String getArquivoConfiguracao() {
    return arquivoConfiguracao;
  }

  public void setArquivoConfiguracao(String arquivoConfiguracao) {
    this.arquivoConfiguracao = arquivoConfiguracao;
  }



}
