package com.pablodomingos.classes.rps;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorCpfCnpj {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("Cpf")
  private String cpf;

  public RpsTomadorCpfCnpj(String documento){
    documento = ValidadorString.cpfCnpj(documento);
    if(documento.length() == 11){
      this.cpf = documento;
    }else if (documento.length() == 14){
      this.cnpj = documento;
    }
   }
  
  public String getDocumento(){
    if(this.cpf != null){
      return this.cpf;
    }else {
      return this.cnpj;
    }
  }
  
  public String getCnpj() {
    return cnpj;
  }

  public String getCpf() {
    return cpf;
  }

}
