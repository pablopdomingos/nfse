package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsValores;
import com.pablodomingos.classes.rps.enums.IssRetido;
import com.pablodomingos.util.DoubleUtil;

public class ValoresBuilder extends AbstractBuilder<RpsValores> {
  
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
    this.aliquota = DoubleUtil.arredondarDuasCasas(aliquota / 100.0);
    this.valorServicos = DoubleUtil.arredondarDuasCasas(valorServicos);
  }

  public ValoresBuilder comValorDeducoes(Double valorDeducoes) {
    this.valorDeducoes = DoubleUtil.arredondarDuasCasas(valorDeducoes);
    return this;
  }

  public ValoresBuilder comValorPis(Double valorPis) {
    this.valorPis = DoubleUtil.arredondarDuasCasas(valorPis);
    return this;
  }

  public ValoresBuilder comValorCofins(Double valorCofins) {
    this.valorCofins = DoubleUtil.arredondarDuasCasas(valorCofins);
    return this;
  }

  public ValoresBuilder comValorInss(Double valorInss) {
    this.valorInss = DoubleUtil.arredondarDuasCasas(valorInss);
    return this;
  }

  public ValoresBuilder comValorIr(Double valorIr) {
    this.valorIr = DoubleUtil.arredondarDuasCasas(valorIr);
    return this;
  }

  public ValoresBuilder comValorCsll(Double valorCsll) {
    this.valorCsll = DoubleUtil.arredondarDuasCasas(valorCsll);
    return this;
  }

  public ValoresBuilder comOutrasRetencoes(Double outrasRetencoes) {
    this.outrasRetencoes = DoubleUtil.arredondarDuasCasas(outrasRetencoes);
    return this;
  }

  public ValoresBuilder comDescontoIncondicionado(Double descontoIncondicionado) {
    this.descontoIncondicionado = DoubleUtil.arredondarDuasCasas(descontoIncondicionado);
    return this;
  }

  public ValoresBuilder comDescontoCondicionado(Double descontoCondicionado) {
    this.descontoCondicionado = DoubleUtil.arredondarDuasCasas(descontoCondicionado);
    return this;
  }

  public ValoresBuilder comIssRetido(boolean issRetido) {
    this.issRetido = issRetido ? IssRetido.SIM : IssRetido.NAO;
    return this;
  }
  
  @Override
  protected RpsValores buildInternal() {
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

