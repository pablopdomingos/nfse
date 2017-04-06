package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class RpsIntermediarioCpfCnpjBH extends AbstractRPS {

  @Element(name="Cpf")
  @CPF
  private String cpf;

  @Element(name="Cnpj")
  @CNPJ
  private String cnpj;

  public RpsIntermediarioCpfCnpjBH(String cpf, String cnpj) {
    super();
    this.cpf = cpf;
    this.cnpj = cnpj;
  }

  public String getDocumento() {
    if (this.cpf != null) {
      return this.cpf;
    } else {
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
