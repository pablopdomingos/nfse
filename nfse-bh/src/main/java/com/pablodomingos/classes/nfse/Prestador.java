package com.pablodomingos.classes.nfse;

import javax.management.InvalidAttributeValueException;

import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Prestador {

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  public Prestador() {}

  public String getCnpj() {
    return cnpj;
  }

  public Prestador comCnpj(String cnpj) throws InvalidAttributeValueException {
    cnpj = cnpj.replaceAll("[^0-9]", "");
    if (cnpj.length() == 14){
      this.cnpj = cnpj;
    }else {
      throw new InvalidAttributeValueException("CPF ou CNPJ excedeu o tamanho do campo");
    }
    return this;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public Prestador comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal prestador");
    return this;
  }

}
