package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import org.hibernate.validator.constraints.br.CNPJ;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsPrestadorBH extends AbstractRPS {

  @Element(name="Cnpj")
  @NotNull
  @CNPJ
  private String cnpj;

  @Element(name="InscricaoMunicipal")
  @Size(min = 1, max = 15)
  private String inscricaoMunicipal;

  public RpsPrestadorBH(PrestadorBuilder builder) {
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
