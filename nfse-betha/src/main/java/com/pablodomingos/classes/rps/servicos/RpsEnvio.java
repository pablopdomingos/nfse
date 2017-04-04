package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.Rps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.validation.Valid;

@XStreamAlias("GerarNfseEnvio")
public class RpsEnvio extends AbstractService{

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @XStreamAlias("Rps")
  @Valid
  private Rps rps;

  public RpsEnvio(Rps rps) {
    this.rps = rps;
  }
  
}
