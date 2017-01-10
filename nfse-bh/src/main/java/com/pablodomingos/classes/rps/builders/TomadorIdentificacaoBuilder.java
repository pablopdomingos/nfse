package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorCpfCnpj;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacao;

public class TomadorIdentificacaoBuilder extends AbstractBuilder<RpsTomadorIdentificacao>{

  
  private String inscricaoMunicipal;
  private RpsTomadorCpfCnpj cpfCnpj;

  public TomadorIdentificacaoBuilder() {}

  public TomadorIdentificacaoBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  public TomadorIdentificacaoBuilder comCpfCnpj(RpsTomadorCpfCnpj cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }
  
  @Override
  protected RpsTomadorIdentificacao buildInternal() {
    return new RpsTomadorIdentificacao(this);
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public RpsTomadorCpfCnpj getCpfCnpj() {
    return cpfCnpj;
  }

  
}

