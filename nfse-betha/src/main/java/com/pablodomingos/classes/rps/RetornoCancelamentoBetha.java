package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

public class RetornoCancelamentoBetha {
  @Element(name="NfseCancelamento", required = false)
  NfseRetornoCancelamentoBetha nfseCancelamento;

  public NfseRetornoCancelamentoBetha getNfseCancelamento() {
    return nfseCancelamento;
  }
}

