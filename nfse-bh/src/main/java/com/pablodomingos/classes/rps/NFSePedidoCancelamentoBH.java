package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSePedidoCancelamentoBH extends AbstractRPS {

  @Element(name="InfPedidoCancelamento")
  @NotNull
  private NFSeInfPedidoCancelamentoBH infPedidoCancelamento;
  
  public NFSePedidoCancelamentoBH(NFSeInfPedidoCancelamentoBH infPedidoCancelamento) {
    this.infPedidoCancelamento = infPedidoCancelamento;
  }

  public NFSeInfPedidoCancelamentoBH getInfPedidoCancelamento() {
    return infPedidoCancelamento;
  }
}
