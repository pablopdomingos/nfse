package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSePedidoCancelamento {

  @XStreamAlias("InfPedidoCancelamento")
  @NotNull
  private NFSeInfPedidoCancelamento infPedidoCancelamento;
  
  public NFSePedidoCancelamento(NFSeInfPedidoCancelamento infPedidoCancelamento) {
    this.infPedidoCancelamento = infPedidoCancelamento;
  }

  public NFSeInfPedidoCancelamento getInfPedidoCancelamento() {
    return infPedidoCancelamento;
  }
}
