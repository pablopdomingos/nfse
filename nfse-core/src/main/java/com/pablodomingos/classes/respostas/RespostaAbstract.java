package com.pablodomingos.classes.respostas;

import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

public abstract class RespostaAbstract {
  @ElementList(name = "ListaMensagemRetorno", required = false)
  private ArrayList<MensagemRetornoResposta> mensagens;

  public ArrayList<MensagemRetornoResposta> getMensagens() {
    return mensagens;
  }

  public void setMensagens(ArrayList<MensagemRetornoResposta> mensagens) {
    this.mensagens = mensagens;
  }
}
