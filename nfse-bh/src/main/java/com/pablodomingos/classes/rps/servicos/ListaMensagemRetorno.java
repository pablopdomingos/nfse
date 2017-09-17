package com.pablodomingos.classes.rps.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ListaMensagemRetorno")
public class ListaMensagemRetorno {

  @XStreamImplicit
  private List<MensagemRetorno> mensagemRetorno = new ArrayList<>();

  public List<MensagemRetorno> getMensagemRetorno() {
    return mensagemRetorno;
  }

  public void setMensagemRetorno(List<MensagemRetorno> mensagemRetorno) {
    this.mensagemRetorno = mensagemRetorno;
  }

  @Override
  public String toString() {
    if (this.getMensagemRetorno() != null) {
      List<String> mensagens = this.getMensagemRetorno().stream().map(MensagemRetorno::toString)
          .collect(Collectors.toList());
      return mensagens.stream().map(m -> m.toString()).collect(Collectors.joining("|"));
    }

    return null;
  }

}
