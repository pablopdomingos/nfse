package com.pablodomingos.classes.nfse;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj {

  @XStreamAlias("Cnpj")
  private String Cnpj;

  @XStreamAlias("Cpf")
  private String Cpf;

  public NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj() {}

  public void setCpf(String cpf) {
    Cpf = ValidadorString.comTamanhoExato(11, cpf, "Cpf tomador");
  }

  public String getCnpj() {
    return Cnpj;
  }

  public void setCnpj(String cnpj) {
    Cnpj = ValidadorString.comTamanhoExato(14, cnpj, "Cnpj tomador");
  }

  public String getCpf() {
    return Cpf;
  }

}
