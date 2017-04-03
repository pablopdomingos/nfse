package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class RpsIntermediarioCpfCnpj extends AbstractRPS {

  @XStreamAlias("Cpf")
  @CPF
  private String cpf;

  @XStreamAlias("Cnpj")
  @CNPJ
  private String cnpj;

  public RpsIntermediarioCpfCnpj(String cpf, String cnpj) {
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
