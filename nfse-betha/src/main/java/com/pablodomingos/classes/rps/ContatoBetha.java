package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContatoBetha extends AbstractRPS {

  @Element(name="Telefone", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min=10, max=11)
  private String telefone;

  @Element(name="Email", required = false)
  @Pattern(regexp = "^(.+)@(.+)$")
  @Size(min=1, max=80)
  private String email;

  public ContatoBetha() {
  }

  public ContatoBetha(String telefone, String email) {
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
