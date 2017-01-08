package com.pablodomingos.classes.rps;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.TomadorContatoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomadorContato {

  @XStreamAlias("Telefone")
  @Pattern(regexp = "\\d+")
  @Size(min=10, max=11)
  private String telefone;

  @XStreamAlias("Email")
  @Pattern(regexp = "^(.+)@(.+)$")
  @Size(min=1, max=80)
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
