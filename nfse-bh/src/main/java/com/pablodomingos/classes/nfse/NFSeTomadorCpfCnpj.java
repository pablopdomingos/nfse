package com.pablodomingos.classes.nfse;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeTomadorCpfCnpj {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("Cpf")
  private String cpf;

  public NFSeTomadorCpfCnpj() {}

  public NFSeTomadorCpfCnpj comDocumento(String documento){
    documento = ValidadorString.cpfCnpj(documento);
    if(documento.length() == 11){
      setCpf(documento);
    }else if (documento.length() == 14){
      setCnpj(documento);
    }
    return this;
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
