package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.validadores.ValidadorString;

public class TomadorContatoBuilder{

  private String telefone;
  private String email;
  
  public TomadorContatoBuilder() {}

  public TomadorContatoBuilder comTelefone(String telefone) {
    this.telefone = ValidadorString.comTamanhoMaximoEMinimo(15, 1, telefone, "Telefone");
    return this;
  }

  public TomadorContatoBuilder comEmail(String email) {
    this.email = ValidadorString.comTamanhoMaximoEMinimo(80, 1, email, "Email");
    return this;
  }
   
  public RpsTomadorContato build() {
    return new RpsTomadorContato(this);
  }
  
  public String getTelefone() {
    return telefone;
  }

  public String getEmail() {
    return email;
  }
}

