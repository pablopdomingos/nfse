package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Size;

public class RpsCpfCnpjBetha extends AbstractRPS {

  @Element(name="Cnpj", required = false)
  @CNPJ
  @Size(min = 14, max = 14)
  private String cnpj;

  @Element(name="Cpf", required = false)
  @CPF
  @Size(min = 11, max = 11)
  private String cpf;

  public RpsCpfCnpjBetha(String documento) {
    if (documento != null)
    {
      if (documento.length() == 14) {
        this.cnpj = documento;
      }
      else {
        this.cpf = documento;
      }
    }
  }
  public RpsCpfCnpjBetha(String cpf, String cnpj) {
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
