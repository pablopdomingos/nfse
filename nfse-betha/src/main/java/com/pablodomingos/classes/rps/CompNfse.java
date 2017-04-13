package com.pablodomingos.classes.rps;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CompNfse")
public class CompNfse {

  @Element(name = "Nfse", required = false)
  private Nfse nfse;

  @Element(name = "NfseCancelamento", required = false)
  private NfseRetornoCancelamentoBetha nfseCancelamento;

  public Nfse getNfse() {
    return this.nfse;
  }

  public static class Nfse {

    @Element(name = "InfNfse", required = false)
    InfNfse infNfse;


    @Attribute(name = "versao", required = false)
    String versao;

    public InfNfse getInfNfse() {
      return infNfse;
    }

    public String getVersao() {
      return versao;
    }
  }
}