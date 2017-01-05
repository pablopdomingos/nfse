package com.pablodomingos.classes.nfse;

import javax.management.InvalidAttributeValueException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TomadorCpfCnpj {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("Cpf")
  private String cpf;

  public TomadorCpfCnpj() {}

  public TomadorCpfCnpj comDocumento(String documento) throws InvalidAttributeValueException{
    documento = documento.replaceAll("[^0-9]", "");
    if(documento.length() == 11){
      setCpf(documento);
    }else if (documento.length() == 14){
      setCnpj(documento);
    }else {
      throw new InvalidAttributeValueException("CPF ou CNPJ excedeu o tamanho do campo");
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
