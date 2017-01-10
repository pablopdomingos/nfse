package com.pablodomingos.classes.rps;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.pablodomingos.classes.rps.builders.TomadorCpfCnpjBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorCpfCnpj {

  @XStreamAlias("Cnpj")
  @CNPJ
  @Size(min = 14, max = 14)
  private String cnpj;

  @XStreamAlias("Cpf")
  @CPF
  @Size(min = 11, max = 11)
  private String cpf;

  public RpsTomadorCpfCnpj(TomadorCpfCnpjBuilder builder) {

    this.cpf = builder.getCpf();
    this.cnpj = builder.getCnpj();

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
