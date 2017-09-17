package com.pablodomingos.classes.rps.servicos;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CompNfse")
public class CompNFSe {

  @XStreamAlias("Nfse")
  private NFSe nfse;

  public NFSe getNfse() {
    return nfse;
  }

  public void setNfse(NFSe nfse) {
    this.nfse = nfse;
  }

  public static CompNFSe toPojo(String xml) {
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    xstream.ignoreUnknownElements();
    xstream.alias("CompNfse", CompNFSe.class);
    xstream.alias("Nfse", NFSe.class);
    CompNFSe compNfse = (CompNFSe) xstream.fromXML(xml);
    return compNfse;
  }

}
