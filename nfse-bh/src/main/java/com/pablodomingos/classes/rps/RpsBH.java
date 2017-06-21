package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name="Rps")
public class RpsBH extends AbstractRPS {
    
  @Element(name="InfRps")
  @Valid
  private RpsInfoBH rpsInfo;

  public RpsBH(RpsInfoBuilder builder) {
    this.rpsInfo = new RpsInfoBH(builder);
  }

  public RpsInfoBH getRpsInfo() {
    return rpsInfo;
  }
}
