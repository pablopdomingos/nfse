package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.LoteRps;
<<<<<<< HEAD
import com.thoughtworks.xstream.XStream;
=======
>>>>>>> 043835f05c7e265fd3b9ea061abbef840b63aa14
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("EnviarLoteRpsEnvio")
public class LoteRpsEnvio extends AbstractService{

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("LoteRps")
  private LoteRps loteRps;

  public LoteRpsEnvio(LoteRps loteRps) {
    this.loteRps = loteRps;
    }

}
