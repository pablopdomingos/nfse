package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.Valid;

@XStreamAlias("Rps")
public class Rps extends AbstractRPS {
    
  @XStreamAlias("InfDeclaracaoPrestacaoServico")
  @Valid
  private RpsInfo rpsInfo;

  public Rps(RpsInfoBuilder builder) {
    this.rpsInfo = new RpsInfo(builder);
  }

  public RpsInfo getRpsInfo() {
    return rpsInfo;
  }
}
