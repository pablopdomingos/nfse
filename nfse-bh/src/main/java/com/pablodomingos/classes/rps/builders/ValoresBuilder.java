package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.enums.IssRetido;
import com.pablodomingos.classes.rps.RpsValores;
import com.pablodomingos.validadores.ValidadorDecimal;

public class ValoresBuilder {

  private Double valorServicos = 0.0;
  private Double valorDeducoes;
  private Double valorPis;
  private Double valorCofins;
  private Double valorInss;
  private Double valorIr;
  private Double valorCsll;
  private IssRetido issRetido = IssRetido.NAO;
  private Double outrasRetencoes;
  private Double aliquota = 0.0;
  private Double descontoIncondicionado;
  private Double descontoCondicionado;

  public ValoresBuilder(Double valorServicos, Double aliquota) {
    if (Double.isNaN(aliquota) || Double.isNaN(valorServicos) || valorServicos == 0) {
      throw new IllegalArgumentException("Valor do serviço ou aliquota não podem ser nulos");
    }
    this.aliquota = ValidadorDecimal.tamanho5Com4CasasDecimais(aliquota / 100.0);
    this.valorServicos = ValidadorDecimal.tamanho15Com2CasasDecimais(valorServicos);
  }

  public ValoresBuilder comValorDeducoes(Double valorDeducoes) {
    this.valorDeducoes = ValidadorDecimal.tamanho15Com2CasasDecimais(valorDeducoes);
    return this;
  }

  public ValoresBuilder comValorPis(Double valorPis) {
    this.valorPis = ValidadorDecimal.tamanho15Com2CasasDecimais(valorPis);
    return this;
  }

  public ValoresBuilder comValorCofins(Double valorCofins) {
    this.valorCofins = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCofins);
    return this;
  }

  public ValoresBuilder comValorInss(Double valorInss) {
    this.valorInss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorInss);
    return this;
  }

  public ValoresBuilder comValorIr(Double valorIr) {
    this.valorIr = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIr);
    return this;
  }

  public ValoresBuilder comValorCsll(Double valorCsll) {
    this.valorCsll = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCsll);
    return this;
  }

  public ValoresBuilder comOutrasRetencoes(Double outrasRetencoes) {
    this.outrasRetencoes = ValidadorDecimal.tamanho15Com2CasasDecimais(outrasRetencoes);
    return this;
  }

  public ValoresBuilder comDescontoIncondicionado(Double descontoIncondicionado) {
    this.descontoIncondicionado =
        ValidadorDecimal.tamanho15Com2CasasDecimais(descontoIncondicionado);
    return this;
  }

  public ValoresBuilder comDescontoCondicionado(Double descontoCondicionado) {
    this.descontoCondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoCondicionado);
    return this;
  }

  public ValoresBuilder comIssRetido(boolean issRetido) {
    this.issRetido = issRetido ? IssRetido.SIM : IssRetido.NAO;
    return this;
  }

  public RpsValores build() {
    return new RpsValores(this);
  }

  public Double getValorServicos() {
    return valorServicos;
  }

  public Double getValorDeducoes() {
    return valorDeducoes;
  }

  public Double getValorPis() {
    return valorPis;
  }

  public Double getValorCofins() {
    return valorCofins;
  }

  public Double getValorInss() {
    return valorInss;
  }

  public Double getValorIr() {
    return valorIr;
  }

  public Double getValorCsll() {
    return valorCsll;
  }

  public IssRetido getIssRetido() {
    return issRetido;
  }

  public Double getOutrasRetencoes() {
    return outrasRetencoes;
  }

  public Double getAliquota() {
    return aliquota;
  }

  public Double getDescontoIncondicionado() {
    return descontoIncondicionado;
  }

  public Double getDescontoCondicionado() {
    return descontoCondicionado;
  }

}

