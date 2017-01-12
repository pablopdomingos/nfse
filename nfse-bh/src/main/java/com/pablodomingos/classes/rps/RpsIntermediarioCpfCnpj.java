package com.pablodomingos.classes.rps;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.pablodomingos.classes.rps.builders.IntermediarioCpfCnpjBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsIntermediarioCpfCnpj {

  @XStreamAlias("Cnpj")
  @CNPJ
  private String cnpj;

  @XStreamAlias("Cpf")
  @CPF
  private String cpf;

  public RpsIntermediarioCpfCnpj(IntermediarioCpfCnpjBuilder builder) {

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
