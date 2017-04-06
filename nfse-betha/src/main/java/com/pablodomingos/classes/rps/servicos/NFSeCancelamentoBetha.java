package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.NFSePedidoCancelamentoBetha;
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
  private NFSePedidoCancelamentoBetha pedido;
  
  public NFSeCancelamentoBetha(NFSePedidoCancelamentoBetha pedido) {
    super();
    this.pedido = pedido;
  }
}
