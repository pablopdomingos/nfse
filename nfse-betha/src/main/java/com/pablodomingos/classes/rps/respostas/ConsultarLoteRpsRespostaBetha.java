package com.pablodomingos.classes.rps.respostas;

import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ConsultarLoteRpsRespostaBetha")
public class ConsultarLoteRpsRespostaBetha {
  @Element(name = "Situacao")
  private SituacaoLoteRps situacao;

  @ElementList(name = "ListaNfse", required = false)
  private List<Object> listaNFSe;

  public SituacaoLoteRps getSituacao() {
    return situacao;
  }

  public void setSituacao(SituacaoLoteRps situacao) {
    this.situacao = situacao;
  }

  public List<Object> getListaNFSe() {
    return listaNFSe;
  }

  public void setListaNFSe(List<Object> listaNFSe) {
    this.listaNFSe = listaNFSe;
  }
}
