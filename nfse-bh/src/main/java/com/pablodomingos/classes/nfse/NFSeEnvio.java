package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("GerarNfseEnvio")
public class NFSeEnvio {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("LoteRps")
  private NFSeLoteRps loteRps;

  public NFSeEnvio() {}

  public void setLoteRps(NFSeLoteRps loteRps) {
    this.loteRps = loteRps;
  }

}
