package com.pablodomingos.classes.rps;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NFSeIdentificacao extends AbstractRPS {

  @XStreamAlias("Numero")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=15)
  private String numero;
  
  @XStreamAlias("Cnpj")
  @NotNull
  @CNPJ
  private String cnpj;
 
  @XStreamAlias("InscricaoMunicipal")
  @Size(min = 1, max = 15)
  private String inscricaoMunicipal;
  
  @XStreamAlias("CodigoMunicipio")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoMunicipioIbge;

  public NFSeIdentificacao(String numero, String cnpj, String inscricaoMunicipal, String codigoMunicipioIbge) {
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
