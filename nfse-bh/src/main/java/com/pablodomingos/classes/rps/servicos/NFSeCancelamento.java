package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.NFSePedidoCancelamento;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("CancelarNfseEnvio")
public class NFSeCancelamento {

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

  public String converterParaXml() {
    String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    
    return XML_HEADER + xstream.toXML(this);
  }

}
