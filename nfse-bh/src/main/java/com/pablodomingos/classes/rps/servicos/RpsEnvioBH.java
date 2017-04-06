package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRpsBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name="GerarNfseEnvio")
public class RpsEnvioBH extends AbstractServiceBH {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="LoteRps")
  @Valid
  private LoteRpsBH loteRps;

  public RpsEnvioBH(LoteRpsBH loteRps) {
    this.loteRps = loteRps;
    }
  
}
