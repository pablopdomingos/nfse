package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsIntermediarioCpfCnpj;

public class IntermediarioCpfCnpjBuilder extends AbstractBuilder<RpsIntermediarioCpfCnpj>{

  
  private String cpf;
  private String cnpj;


  public IntermediarioCpfCnpjBuilder(){}

  public IntermediarioCpfCnpjBuilder comDocumento(String documento) {
    if(documento.length() == 11){
      this.cpf = documento;
    }else{
      this.cnpj = documento;
    }
    return this;
  }
  
  @Override
  public RpsIntermediarioCpfCnpj buildInternal() {
    return new RpsIntermediarioCpfCnpj(this);
  }

  public String getCpf() {
    return cpf;
  }

  public String getCnpj() {
    return cnpj;
  }


}

