package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorContato;

public class TomadorContatoBuilder extends AbstractBuilder<RpsTomadorContato>{
  
  
  private String telefone;
  private String email;
  
  public TomadorContatoBuilder() {}

  public TomadorContatoBuilder comTelefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  public TomadorContatoBuilder comEmail(String email) {
    this.email = email;
    return this;
  }
   
  @Override
  protected RpsTomadorContato buildInternal() {
    return new RpsTomadorContato(this);
  }
  
  public String getTelefone() {
    return telefone;
  }

  public String getEmail() {
    return email;
  }
}

