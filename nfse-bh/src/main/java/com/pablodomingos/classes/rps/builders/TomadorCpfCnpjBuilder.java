package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorCpfCnpj;

public class TomadorCpfCnpjBuilder extends AbstractBuilder<RpsTomadorCpfCnpj>{

  
  private String cpf;
  private String cnpj;

  public TomadorCpfCnpjBuilder() {}

  public TomadorCpfCnpjBuilder comDocumento(String documento) {
    if(documento.length() == 11){
      this.cpf = documento;
    }else{
      this.cnpj = documento;
    }
    return this;
  }

  @Override
  protected RpsTomadorCpfCnpj buildInternal() {
    return new RpsTomadorCpfCnpj(this);
  }

  public String getCpf() {
    return cpf;
  }

  public String getCnpj() {
    return cnpj;
  }
  
}

