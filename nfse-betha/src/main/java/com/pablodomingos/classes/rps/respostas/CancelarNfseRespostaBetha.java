package com.pablodomingos.classes.rps.respostas;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "CancelarNfseRespostaBetha")
public class CancelarNfseRespostaBetha {
  @ElementList(name = "ListaMensagemRetorno", required = false)
  private ArrayList<MensagemRetornoResposta> mensagens;

  public ArrayList<MensagemRetornoResposta> getMensagens() {
    return mensagens;
  }

  public void setMensagens(ArrayList<MensagemRetornoResposta> mensagens) {
    this.mensagens = mensagens;
  }
}
