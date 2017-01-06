package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeTomadorContato {

  @XStreamAlias("Telefone")
  private String telefone;

  @XStreamAlias("Email")
  private String email;

  public NFSeTomadorContato(){}
  
  public String getEmail() {
    return email;
  }

  public NFSeTomadorContato comEmail(String email) {
    this.email = StringUtil.removeAcentos(email);
    return this;
  }

  public String getTelefone() {
    return telefone;
  }

  public NFSeTomadorContato comTelefone(String telefone) {
    telefone = telefone.replaceAll("[^0-9]", "");
    this.telefone = ValidadorString.comTamanhoMaximoEMinimo(11, 1, telefone, "Telefone");
    return this;
  }

}
