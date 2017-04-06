package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NFSeIdentificacaoBH extends AbstractRPS {

  @Element(name="Numero")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=15)
  private String numero;
  
  @Element(name="Cnpj")
  @NotNull
  @CNPJ
  private String cnpj;
 
  @Element(name="InscricaoMunicipal")
  @Size(min = 1, max = 15)
  private String inscricaoMunicipal;
  
  @Element(name="CodigoMunicipio")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoMunicipioIbge;

  public NFSeIdentificacaoBH(String numero, String cnpj, String inscricaoMunicipal, String codigoMunicipioIbge) {
    this.numero = numero;
    this.cnpj = cnpj;
    this.inscricaoMunicipal = inscricaoMunicipal;
    this.codigoMunicipioIbge = codigoMunicipioIbge;
  }

  public String getNumero() {
    return numero;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public String getCodigoMunicipioIbge() {
    return codigoMunicipioIbge;
  }
  
}
