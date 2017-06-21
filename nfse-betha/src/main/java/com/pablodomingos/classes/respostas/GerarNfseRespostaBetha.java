package com.pablodomingos.classes.respostas;

import com.pablodomingos.classes.rps.CompNfse;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "GerarNfseResposta")
public class GerarNfseRespostaBetha extends RespostaAbstract {
  @ElementList(name = "ListaNfse", required = false)
  ArrayList<CompNfse> listaNfse = new ArrayList<>();

  public ArrayList<CompNfse> getListaNfse() {
    return listaNfse;
  }

  public void setListaNfse(ArrayList<CompNfse> listaNfse) {
    this.listaNfse = listaNfse;
  }
}
