package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.enums.ExigibilidadeIss;

public class ServicoBuilder extends AbstractBuilder {

  private ValoresBuilder valores;
  private String codigoItemListaServico;
  private String codigoCnae;
  private String codigoPais;
  private String codigoTributacaoMunicipio;
  private String discriminacao;
  private String codigoMunicipio;
  private ExigibilidadeIss exigibilidadeIss;
  private String municipioIncidencia;
  private String numeroProcesso;

  public ServicoBuilder(ValoresBuilder valores, String codigoItemListaServico) {
    this.valores = valores;
    this.codigoItemListaServico = codigoItemListaServico;
  }

  public ServicoBuilder comCodigoCnae(Integer codigoCnae) {
    return comCodigoCnae(Integer.toString(codigoCnae));
  }

  public ServicoBuilder comCodigoCnae(String codigoCnae) {
    this.codigoCnae = codigoCnae;
    return this;
  }

  public ServicoBuilder comDiscriminacao(String discriminacao) {
    this.discriminacao = discriminacao;
    return this;
  }

  public ServicoBuilder comCodigoMunicipio(Integer codigoMunicipio) {
    return comCodigoMunicipio(Integer.toString(codigoMunicipio));
  }

  public ServicoBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
    return this;
  }

  public ServicoBuilder comCodigoPais(String codigoPais) {
    this.codigoPais = codigoPais;
    return this;
  }

  public ServicoBuilder comCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
    this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
    return this;
  }

  public ServicoBuilder comExigibilidadeISS(ExigibilidadeIss exigibilidadeIss) {
    this.exigibilidadeIss = exigibilidadeIss;
    return this;
  }

  public ServicoBuilder comMunicipioIncidencia(Integer municipioIncidencia) {
    return comMunicipioIncidencia(String.valueOf(municipioIncidencia));
  }

  public ServicoBuilder comMunicipioIncidencia(String municipioIncidencia) {
    this.municipioIncidencia = municipioIncidencia;
    return this;
  }

  public ServicoBuilder comNumeroProcesso(String numeroProcesso) {
    this.numeroProcesso = numeroProcesso;
    return this;
  }

  public ValoresBuilder getValores() {
    return valores;
  }

  public String getCodigoItemListaServico() {
    return codigoItemListaServico;
  }

  public String getCodigoCnae() {
    return codigoCnae;
  }

  public String getCodigoTributacaoMunicipio() {
    return codigoTributacaoMunicipio;
  }

  public String getDiscriminacao() {
    return discriminacao;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public ExigibilidadeIss getExigibilidadeIss() {
    return exigibilidadeIss;
  }

  public String getCodigoPais() {
    if (exigibilidadeIss == ExigibilidadeIss.EXPORTACAO) {
      return codigoPais;
    }
    return null;
  }

  public String getMunicipioIncidencia() {
    return municipioIncidencia;
  }

  public String getNumeroProcesso() {
    return numeroProcesso;
  }
}

