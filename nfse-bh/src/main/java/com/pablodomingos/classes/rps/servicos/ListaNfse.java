package com.pablodomingos.classes.rps.servicos;

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ListaNfse {

  @XStreamImplicit
  private List<CompNFSe> compNfse;

  public List<CompNFSe> getCompNfse() {
    return compNfse;
  }

  public void setCompNfse(List<CompNFSe> compNfse) {
    this.compNfse = compNfse;
  }

}
