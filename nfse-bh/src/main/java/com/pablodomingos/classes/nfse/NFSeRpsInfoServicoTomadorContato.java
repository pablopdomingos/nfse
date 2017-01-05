package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoTomadorContato {

  @XStreamAlias("Telefone")
  private String telefone;

  @XStreamAlias("Email")
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = StringUtil.removeAcentos(email);
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

}
