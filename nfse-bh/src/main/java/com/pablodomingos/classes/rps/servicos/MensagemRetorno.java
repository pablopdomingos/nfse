package com.pablodomingos.classes.rps.servicos;


import com.pablodomingos.classes.rps.RpsIdentificacao;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MensagemRetorno")
public class MensagemRetorno {

  @XStreamAlias("Mensagem")
  private String mensagem;

  @XStreamAlias("Codigo")
  private String codigo;

  @XStreamAlias("IdentificacaoRps")
  private RpsIdentificacao rpsIdentificacao;

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public RpsIdentificacao getRpsIdentificacao() {
    return rpsIdentificacao;
  }

  public void setRpsIdentificacao(RpsIdentificacao rpsIdentificacao) {
    this.rpsIdentificacao = rpsIdentificacao;
  }

}
