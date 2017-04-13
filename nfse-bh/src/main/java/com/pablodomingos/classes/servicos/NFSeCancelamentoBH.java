package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.NFSePedidoCancelamentoBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="CancelarNfseEnvio")
public class NFSeCancelamentoBH extends AbstractServiceBH {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="Pedido")
  @NotNull
  private NFSePedidoCancelamentoBH pedido;
  
  public NFSeCancelamentoBH(NFSePedidoCancelamentoBH pedido) {
    super();
    this.pedido = pedido;
  }
}
