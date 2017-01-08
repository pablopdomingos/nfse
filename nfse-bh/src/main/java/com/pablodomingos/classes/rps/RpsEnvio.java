package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("GerarNfseEnvio")
public class RpsEnvio {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("LoteRps")
  private LoteRps loteRps;

  public RpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;}

  public String converterParaXml() {
    String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    
    return XML_HEADER + xstream.toXML(this);
  }
}
