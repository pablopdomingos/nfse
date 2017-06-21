package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NfsePedidoCancelamentoBetha extends AbstractRPS {

    @Element(name = "InfPedidoCancelamento", required = false)
    @NotNull
    private NfseInfPedidoCancelamentoBetha infPedidoCancelamento;

    public NfsePedidoCancelamentoBetha() {
    }

    public NfsePedidoCancelamentoBetha(NfseInfPedidoCancelamentoBetha infPedidoCancelamento) {
        this.infPedidoCancelamento = infPedidoCancelamento;
    }

    public NfseInfPedidoCancelamentoBetha getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }
}
