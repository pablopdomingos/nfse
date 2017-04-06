package com.pablodomingos.classes.rps.respostas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MensagemRetorno")
public class MensagemRetornoResposta {
  @Element(name = "Codigo")
  private String codigo;

  @Element(name = "Mensagem")
  private String mensagem;

  @Element(name = "Correcao")
  private String correcao;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getCorrecao() {
    return correcao;
  }

  public void setCorrecao(String correcao) {
    this.correcao = correcao;
  }
}