package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Size;

public class RpsTomadorCpfCnpj extends AbstractRPS {

  @XStreamAlias("Cnpj")
  @CNPJ
  @Size(min = 14, max = 14)
  private String cnpj;

  @XStreamAlias("Cpf")
  @CPF
  @Size(min = 11, max = 11)
  private String cpf;

  public RpsTomadorCpfCnpj(String cpf, String cnpj) {
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
