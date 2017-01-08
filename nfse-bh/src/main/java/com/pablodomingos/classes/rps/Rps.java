package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;

  @XStreamAlias("Rps")
  public class Rps {
    
  @XStreamAlias("InfRps")
  private RpsInfo rpsInfo;

  public Rps(RpsInfo rpsInfo) {
    
    this.rpsInfo = rpsInfo;
    
  }

  public RpsInfo getRpsInfo() {
    return rpsInfo;
  }
}
