package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.TomadorContatoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorContato {

  @XStreamAlias("Telefone")
  private String telefone;

  @XStreamAlias("Email")
  private String email;

  public RpsTomadorContato(TomadorContatoBuilder builder){
    email = builder.getEmail();
    telefone = builder.getTelefone();
  }
  
  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }
}
