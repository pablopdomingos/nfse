package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.NFSePedidoCancelamento;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("CancelarNfseEnvio")

public class NFSeCancelamento extends AbstractServiceBetha {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("Pedido")
  @NotNull
  private NFSePedidoCancelamento pedido;
  
  public NFSeCancelamento(NFSePedidoCancelamento pedido) {
    super();
    this.pedido = pedido;
  }
}
