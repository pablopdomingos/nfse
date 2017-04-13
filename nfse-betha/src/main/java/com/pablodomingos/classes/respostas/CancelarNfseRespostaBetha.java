package com.pablodomingos.classes.respostas;

import com.pablodomingos.classes.rps.RetornoCancelamentoBetha;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CancelarNfseRespostaBetha")
public class CancelarNfseRespostaBetha extends RespostaAbstract {

  @Element(name="RetCancelamento", required = false)
  private RetornoCancelamentoBetha retCancelamento;

  public RetornoCancelamentoBetha getRetCancelamento() {
    return retCancelamento;
  }
}
