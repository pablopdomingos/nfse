package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.NFSeIdentificacao;


public class IdentificacaoNFSeBuilder extends AbstractBuilder<NFSeIdentificacao>{

  private String numero;
  private String cnpj;
  private String inscricaoMunicipal;
  private String codigoMunicipioIbge;
  
  public IdentificacaoNFSeBuilder() {}
  
  public IdentificacaoNFSeBuilder comNumero(String numero){
    this.numero = numero;
    return this;
  }
  
  public IdentificacaoNFSeBuilder comCnpj(String cnpj){
    this.cnpj = cnpj;
    return this;
  }
  
  public IdentificacaoNFSeBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  public IdentificacaoNFSeBuilder comCodigoMunicipioIbge(String codigoMunicipioIbge){
    this.codigoMunicipioIbge = codigoMunicipioIbge;
    return this;
  }
  
  @Override
  protected NFSeIdentificacao buildInternal() {
    return new NFSeIdentificacao(this);
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
