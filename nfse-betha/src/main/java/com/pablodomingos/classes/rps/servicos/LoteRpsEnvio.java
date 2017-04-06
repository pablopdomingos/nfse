package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRps;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="EnviarLoteRpsEnvio")
public class LoteRpsEnvio extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="LoteRps")
  private LoteRps loteRps;

  public LoteRpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;
    }

}
