package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.NfsePedidoCancelamentoBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="CancelarNfseEnvio")
public class NFSeCancelamentoBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="Pedido")
  @NotNull
  private NfsePedidoCancelamentoBetha pedido;

  public NFSeCancelamentoBetha() {
  }

  public NFSeCancelamentoBetha(NfsePedidoCancelamentoBetha pedido) {
    super();
    this.pedido = pedido;
  }
}
