package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.validation.Valid;

@XStreamAlias("GerarNfseEnvio")
public class RpsEnvio extends AbstractServiceBHISS {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("LoteRps")
  @Valid
  private LoteRps loteRps;

  public RpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;
    }
  
}
