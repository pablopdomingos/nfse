package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

  @XStreamAlias("Rps")
  public class NFSeRps {
    
  @XStreamAlias("InfRps")
  private NFSeRpsInfo rpsInfo;

  public NFSeRps(NFSeRpsInfo rpsInfo) {
    
    this.rpsInfo = rpsInfo;
    
  }

  public NFSeRpsInfo getRpsInfo() {
    return rpsInfo;
  }
}
