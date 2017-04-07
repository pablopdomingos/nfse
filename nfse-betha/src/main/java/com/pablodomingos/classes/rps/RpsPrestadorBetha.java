package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsPrestadorBetha extends AbstractRPS {

  @Element(name="CpfCnpj")
  @NotNull
  private RpsCpfCnpjBetha cnpj;

  @Element(name="InscricaoMunicipal", required = false)
  @Size(min = 1, max = 15)
  private String inscricaoMunicipal;

  public RpsPrestadorBetha(PrestadorBuilder builder) {
    this.cnpj = new RpsCpfCnpjBetha(builder.getCpf(), builder.getCnpj());
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
  }

  public RpsCpfCnpjBetha getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

}
