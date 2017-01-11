package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.pablodomingos.classes.rps.builders.IdentificacaoNFSeBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeIdentificacao {

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

  public NFSeIdentificacao(IdentificacaoNFSeBuilder builder) {
    this.numero = builder.getNumero();
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
    this.codigoMunicipioIbge = builder.getCodigoMunicipioIbge();
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
