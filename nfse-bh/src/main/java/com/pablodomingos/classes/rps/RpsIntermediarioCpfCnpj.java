package com.pablodomingos.classes.rps;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsIntermediarioCpfCnpj {

  @XStreamAlias("Cnpj")
  @CNPJ
  private String cnpj;

  @XStreamAlias("Cpf")
  @CPF
  private String cpf;

  public RpsIntermediarioCpfCnpj(String documento) {
    if(documento.length() == 11){
      setCpf(documento);
    }else if (documento.length() == 14){
      setCnpj(documento);
    }
  }
  
  public String getDocumento(){
    if(this.cpf != null){
      return this.cpf;
    }else {
      return this.cnpj;
    }
  }
  
  private void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCnpj() {
    return cnpj;
  }

  private void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCpf() {
    return cpf;
  }

}
