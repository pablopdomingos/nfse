package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.NfsePedidoCancelamentoBetha;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="CancelarNfseEnvio")
public class NFSeCancelamentoBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns", required = false)
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Attribute(name="versao", required = false)
  private LoteRpsVersao versao;

  @Element(name="Pedido", required = false)
  @NotNull
  private NfsePedidoCancelamentoBetha pedido;

  public NFSeCancelamentoBetha() {
  }

  public NFSeCancelamentoBetha(NfsePedidoCancelamentoBetha pedido) {
    super();
    this.pedido = pedido;
  }

  public LoteRpsVersao getVersao() {
    return versao;
  }

  public NfsePedidoCancelamentoBetha getPedido() {
    return pedido;
  }
}
