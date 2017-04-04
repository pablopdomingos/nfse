package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsTomadorContato extends AbstractRPS {

  @XStreamAlias("Telefone")
  @Pattern(regexp = "\\d+")
  @Size(min=10, max=11)
  private String telefone;

  @XStreamAlias("Email")
  @Pattern(regexp = "^(.+)@(.+)$")
  @Size(min=1, max=80)
  private String email;

  public RpsTomadorContato(String telefone, String email) {
    this.telefone = telefone;
    this.email = email;
  }
  
  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }
}
