package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSePedidoCancelamentoBetha extends AbstractRPS {

    @Element(name = "InfPedidoCancelamento")
    @NotNull
    private NFSeInfPedidoCancelamentoBetha infPedidoCancelamento;

    public NFSePedidoCancelamentoBetha(NFSeInfPedidoCancelamentoBetha infPedidoCancelamento) {
        this.infPedidoCancelamento = infPedidoCancelamento;
    }

    public NFSeInfPedidoCancelamentoBetha getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }
}
