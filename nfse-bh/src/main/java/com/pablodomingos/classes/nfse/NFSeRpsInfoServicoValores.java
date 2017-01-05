package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.DoubleConversor;
import com.pablodomingos.validadores.ValidadorDecimal;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(DoubleConversor.class)
public class NFSeRpsInfoServicoValores {

  @XStreamAlias("ValorServicos")
  private Double valorServicos = 0.0;

  @XStreamAlias("ValorDeducoes")
  private Double valorDeducoes = 0.0;

  @XStreamAlias("ValorPis")
  private Double valorPis = 0.0;

  @XStreamAlias("ValorCofins")
  private Double valorCofins = 0.0;

  @XStreamAlias("ValorInss")
  private Double valorInss = 0.0;

  @XStreamAlias("ValorIr")
  private Double valorIr = 0.0;

  @XStreamAlias("ValorCsll")
  private Double valorCsll = 0.0;

  @XStreamAlias("IssRetido")
  private NFSeRpsInfoServicoValoresIssRetido issRetido = NFSeRpsInfoServicoValoresIssRetido.NAO;

  @XStreamAlias("ValorIss")
  private Double valorIss = 0.0;

  @XStreamAlias("OutrasRetencoes")
  private Double outrasRetencoes = 0.0;

  @XStreamAlias("Aliquota")
  private Double aliquota = 0.0;

  @XStreamAlias("DescontoIncondicionado")
  private Double descontoIncondicionado = 0.0;

  @XStreamAlias("DescontoCondicionado")
  private Double descontoCondicionado = 0.0;

  public NFSeRpsInfoServicoValores() {
    super();
  }

  public Double getValorServicos() {
    return valorServicos;
  }

  public NFSeRpsInfoServicoValores comValorServicos(Double valorServicos) {
    this.valorServicos = ValidadorDecimal.tamanho15Com2CasasDecimais(valorServicos);
    calculoIss();
    return this;
  }

  public Double getValorDeducoes() {
    return valorDeducoes;
  }

  public NFSeRpsInfoServicoValores comValorDeducoes(Double valorDeducoes) {
    this.valorDeducoes = ValidadorDecimal.tamanho15Com2CasasDecimais(valorDeducoes);
    return this;
  }

  public Double getValorPis() {
    return valorPis;
  }

  public NFSeRpsInfoServicoValores comValorPis(Double valorPis) {
    this.valorPis = ValidadorDecimal.tamanho15Com2CasasDecimais(valorPis);
    return this;
  }

  public Double getValorCofins() {
    return valorCofins;
  }

  public NFSeRpsInfoServicoValores comValorCofins(Double valorCofins) {
    this.valorCofins = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCofins);
    return this;
  }

  public Double getValorInss() {
    return valorInss;
  }

  public NFSeRpsInfoServicoValores comValorInss(Double valorInss) {
    this.valorInss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorInss);
    return this;
  }

  public Double getValorIr() {
    return valorIr;
  }

  public NFSeRpsInfoServicoValores comValorIr(Double valorIr) {
    this.valorIr = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIr);
    return this;
  }

  public Double getValorCsll() {
    return valorCsll;
  }

  public NFSeRpsInfoServicoValores comValorCsll(Double valorCsll) {
    this.valorCsll = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCsll);
    return this;
  }

  public Double getOutrasRetencoes() {
    return outrasRetencoes;
  }

  public NFSeRpsInfoServicoValores comOutrasRetencoes(Double outrasRetencoes) {
    this.outrasRetencoes = ValidadorDecimal.tamanho15Com2CasasDecimais(outrasRetencoes);
    return this;
  }

  public Double getValorIss() {
    return valorIss;
  }

  public NFSeRpsInfoServicoValores comValorIss(Double valorIss) {
    this.valorIss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIss);
    return this;
  }

  public Double getAliquota() {
    return aliquota;
  }

  public NFSeRpsInfoServicoValores comAliquota(Double aliquota) {
    this.aliquota = ValidadorDecimal.tamanho5Com4CasasDecimais(aliquota / 100.0);
    calculoIss();
    return this;
  }

  public Double getDescontoIncondicionado() {
    return descontoIncondicionado;
  }

  public NFSeRpsInfoServicoValores comDescontoIncondicionado(Double descontoIncondicionado) {
    this.descontoIncondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoIncondicionado);
    return this;
  }

  public Double getDescontoCondicionado() {
    return descontoCondicionado;
  }

  public NFSeRpsInfoServicoValores comDescontoCondicionado(Double descontoCondicionado) {
    this.descontoCondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoCondicionado);
    return this;
  }

  public NFSeRpsInfoServicoValoresIssRetido getIssRetido() {
    return issRetido;
  }

  public NFSeRpsInfoServicoValores comIssRetido(boolean issRetido) {
    this.issRetido  = issRetido ? NFSeRpsInfoServicoValoresIssRetido.SIM : NFSeRpsInfoServicoValoresIssRetido.NAO;
    return this;
  }

  private void calculoIss() {
    if (valorServicos != null && aliquota != null) {
      double calc = valorServicos * aliquota;
      valorIss = ValidadorDecimal.tamanho15Com2CasasDecimais(calc);
    }
  }
}
