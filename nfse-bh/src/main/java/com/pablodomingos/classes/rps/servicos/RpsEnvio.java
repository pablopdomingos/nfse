package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRps;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name="GerarNfseEnvio")
public class RpsEnvio extends AbstractServiceBHISS {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="LoteRps")
  @Valid
  private LoteRps loteRps;

  public RpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;
    }
  
}
