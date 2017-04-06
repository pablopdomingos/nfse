package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name = "Rps")
public class RpsBetha extends AbstractRPS {

  @Element(name = "InfDeclaracaoPrestacaoServico")
  @Valid
  private RpsInfoBetha rpsInfo;

  public RpsBetha(RpsInfoBuilder builder) {
    this.rpsInfo = new RpsInfoBetha(builder);
  }

  public RpsInfoBetha getRpsInfo() {
    return rpsInfo;
  }
}
