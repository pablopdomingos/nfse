package com.pablodomingos.classes.respostas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MensagemRetorno")
public class MensagemRetornoResposta {
  @Element(name = "Codigo", required = false)
  private String codigo;

  @Element(name = "Mensagem", required = false)
  private String mensagem;

  @Element(name = "Correcao", required = false)
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