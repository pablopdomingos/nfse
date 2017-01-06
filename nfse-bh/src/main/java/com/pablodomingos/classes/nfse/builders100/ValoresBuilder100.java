package com.pablodomingos.classes.nfse.builders100;

import com.pablodomingos.classes.nfse.NFSeValores;
import com.pablodomingos.classes.nfse.builders.interfaces.ValoresBuilder;
import com.pablodomingos.classes.nfse.enums.IssRetido;
import com.pablodomingos.validadores.ValidadorDecimal;

public class ValoresBuilder100 implements ValoresBuilder {

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

  public ValoresBuilder100(Double valorServicos, Double aliquota) {
    if (Double.isNaN(aliquota) || Double.isNaN(valorServicos) || valorServicos == 0) {
      throw new IllegalArgumentException("Valor do serviço ou aliquota não podem ser nulos");
    }
    this.aliquota = ValidadorDecimal.tamanho5Com4CasasDecimais(aliquota / 100.0);
    this.valorServicos = ValidadorDecimal.tamanho15Com2CasasDecimais(valorServicos);
  }

  public ValoresBuilder100 comValorDeducoes(Double valorDeducoes) {
    this.valorDeducoes = ValidadorDecimal.tamanho15Com2CasasDecimais(valorDeducoes);
    return this;
  }

  public ValoresBuilder100 comValorPis(Double valorPis) {
    this.valorPis = ValidadorDecimal.tamanho15Com2CasasDecimais(valorPis);
    return this;
  }

  public ValoresBuilder100 comValorCofins(Double valorCofins) {
    this.valorCofins = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCofins);
    return this;
  }

  public ValoresBuilder100 comValorInss(Double valorInss) {
    this.valorInss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorInss);
    return this;
  }

  public ValoresBuilder100 comValorIr(Double valorIr) {
    this.valorIr = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIr);
    return this;
  }

  public ValoresBuilder100 comValorCsll(Double valorCsll) {
    this.valorCsll = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCsll);
    return this;
  }

  public ValoresBuilder100 comOutrasRetencoes(Double outrasRetencoes) {
    this.outrasRetencoes = ValidadorDecimal.tamanho15Com2CasasDecimais(outrasRetencoes);
    return this;
  }

  public ValoresBuilder100 comDescontoIncondicionado(Double descontoIncondicionado) {
    this.descontoIncondicionado =
        ValidadorDecimal.tamanho15Com2CasasDecimais(descontoIncondicionado);
    return this;
  }

  public ValoresBuilder100 comDescontoCondicionado(Double descontoCondicionado) {
    this.descontoCondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoCondicionado);
    return this;
  }

  public ValoresBuilder100 comIssRetido(boolean issRetido) {
    this.issRetido = issRetido ? IssRetido.SIM : IssRetido.NAO;
    return this;
  }

  public NFSeValores build() {
    return new NFSeValores(this);
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

