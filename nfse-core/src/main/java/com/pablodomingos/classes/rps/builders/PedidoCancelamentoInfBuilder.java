package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.enums.CodigoCancelamento;

import java.util.UUID;

public class PedidoCancelamentoInfBuilder extends AbstractBuilder {

  private String id;
  private CodigoCancelamento codigoCancelamento;
  private String numero;
  private String cnpj;
  private String inscricaoMunicipal;
  private String codigoMunicipioIbge;

  public PedidoCancelamentoInfBuilder() {
    this.id = UUID.randomUUID().toString();
  }

  public PedidoCancelamentoInfBuilder(String numero) {
    this.numero = numero;
  }

  public PedidoCancelamentoInfBuilder comNumero(String numero){
    this.numero = numero;
    return this;
  }

  public PedidoCancelamentoInfBuilder comCnpj(String cnpj){
    this.cnpj = cnpj;
    return this;
  }

  public PedidoCancelamentoInfBuilder comInscricaoMunicipal(String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  public PedidoCancelamentoInfBuilder comCodigoMunicipioIbge(String codigoMunicipioIbge){
    this.codigoMunicipioIbge = codigoMunicipioIbge;
    return this;
  }

  public PedidoCancelamentoInfBuilder comId(String id){
    this.id = id;
    return this;
  }
  
  public PedidoCancelamentoInfBuilder comCodigoCancelamento(CodigoCancelamento codigoCancelamento){
    this.codigoCancelamento = codigoCancelamento;
    return this;
  }

  public String getId() {
    return id;
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

  public CodigoCancelamento getCodigoCancelamento() {
    return codigoCancelamento;
  }

}
