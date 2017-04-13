package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.servicos.NFSeCancelamentoBetha;
import org.simpleframework.xml.Element;

public class RetornoCancelamentoBetha {
  @Element(name="NfseCancelamento", required = false)
  NFSeCancelamentoBetha nfseCancelamento;

  public NFSeCancelamentoBetha getNfseCancelamento() {
    return nfseCancelamento;
  }
}

