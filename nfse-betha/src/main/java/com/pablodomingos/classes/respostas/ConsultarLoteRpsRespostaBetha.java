package com.pablodomingos.classes.respostas;

import com.pablodomingos.classes.rps.CompNfse;
import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ConsultarLoteRpsResposta")
public class ConsultarLoteRpsRespostaBetha extends RespostaAbstract {
  @Element(name = "Situacao", required = false)
  private SituacaoLoteRps situacao;

  @ElementList(name = "ListaNfse", required = false)
  private ArrayList<CompNfse> listaNFSe;

  public SituacaoLoteRps getSituacao() {
    return situacao;
  }

  public void setSituacao(SituacaoLoteRps situacao) {
    this.situacao = situacao;
  }

  public List<CompNfse> getListaNFSe() {
    return listaNFSe;
  }

  public void setListaNFSe(ArrayList<CompNfse> listaNFSe) {
    this.listaNFSe = listaNFSe;
  }
}
