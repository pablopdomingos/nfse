package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.RpsIdentificacaoRps;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseRpsEnvio")
public class RpsConsulta {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("IdentificacaoRps")
  @NotNull
  private RpsIdentificacaoRps identificacaoRps;

  @XStreamAlias("Prestador")
  @NotNull
  private RpsPrestador prestador;

  public RpsConsulta(RpsIdentificacaoRps identificacaoRps, RpsPrestador prestador) {
    super();
    this.identificacaoRps = identificacaoRps;
    this.prestador = prestador;
  }

  public RpsIdentificacaoRps getIdentificacaoRps() {
    return identificacaoRps;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }

  public String converterParaXml() {
    String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    
    return XML_HEADER + xstream.toXML(this);
  }
}
