package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRps;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="EnviarLoteRpsEnvio")
public class LoteRpsEnvio extends AbstractServiceBHISS {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="LoteRps")
  private LoteRps loteRps;

  public LoteRpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;
    }

}
