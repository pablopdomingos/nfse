package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSePedidoCancelamento extends AbstractRPS {

    @Element(name = "InfPedidoCancelamento")
    @NotNull
    private NFSeInfPedidoCancelamento infPedidoCancelamento;

    public NFSePedidoCancelamento(NFSeInfPedidoCancelamento infPedidoCancelamento) {
        this.infPedidoCancelamento = infPedidoCancelamento;
    }

    public NFSeInfPedidoCancelamento getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }
}
