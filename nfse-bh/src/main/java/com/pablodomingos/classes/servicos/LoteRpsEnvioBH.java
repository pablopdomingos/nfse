package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.LoteRpsBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="EnviarLoteRpsEnvio")
public class LoteRpsEnvioBH extends AbstractServiceBH {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="LoteRps")
  private LoteRpsBH loteRps;

  public LoteRpsEnvioBH(LoteRpsBH loteRps) {
    this.loteRps = loteRps;
    }

}
