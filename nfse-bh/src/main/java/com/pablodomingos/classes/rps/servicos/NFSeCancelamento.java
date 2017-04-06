package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.NFSePedidoCancelamento;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="CancelarNfseEnvio")
public class NFSeCancelamento extends AbstractServiceBHISS {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="Pedido")
  @NotNull
  private NFSePedidoCancelamento pedido;
  
  public NFSeCancelamento(NFSePedidoCancelamento pedido) {
    super();
    this.pedido = pedido;
  }
}
