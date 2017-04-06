package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;

import org.simpleframework.xml.Element;

public class NFSePedidoCancelamento extends AbstractRPS {

  @Element(name="InfPedidoCancelamento")
  @NotNull
  private NFSeInfPedidoCancelamento infPedidoCancelamento;
  
  public NFSePedidoCancelamento(NFSeInfPedidoCancelamento infPedidoCancelamento) {
    this.infPedidoCancelamento = infPedidoCancelamento;
  }

  public NFSeInfPedidoCancelamento getInfPedidoCancelamento() {
    return infPedidoCancelamento;
  }
}
