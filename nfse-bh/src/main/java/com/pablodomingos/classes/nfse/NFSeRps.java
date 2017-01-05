package com.pablodomingos.classes.nfse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

  @XStreamAlias("Rps")
  public class NFSeRps {
    
  @XStreamAlias("InfRps")
  private NFSeRpsInfo rpsInfo;

  public NFSeRps() {
      rpsInfo = new NFSeRpsInfo();
  }

  public NFSeRpsInfo getRpsInfo() {
    return rpsInfo;
  }

  public void setRpsInfo(NFSeRpsInfo rpsInfo) {
    this.rpsInfo = rpsInfo;
  }

}
