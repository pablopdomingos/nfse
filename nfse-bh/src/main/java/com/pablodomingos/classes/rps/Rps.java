package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import org.simpleframework.xml.Element;

import javax.validation.Valid;

@Element(name="Rps")
public class Rps extends AbstractRPS {
    
  @Element(name="InfRps")
  @Valid
  private RpsInfo rpsInfo;

  public Rps(RpsInfoBuilder builder) {
    this.rpsInfo = new RpsInfo(builder);
  }

  public RpsInfo getRpsInfo() {
    return rpsInfo;
  }
}
