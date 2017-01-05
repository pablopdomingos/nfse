package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.DoubleConversor;
import com.pablodomingos.validadores.ValidadorDecimal;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(DoubleConversor.class)
public class NFSeRpsInfoServicoValores {

  @XStreamAlias("ValorServicos")
  private Double valorServicos;

  @XStreamAlias("ValorDeducoes")
  private Double valorDeducoes;

  @XStreamAlias("ValorPis")
  private Double valorPis;

  @XStreamAlias("ValorCofins")
  private Double valorCofins;

  @XStreamAlias("ValorInss")
  private Double valorInss;

  @XStreamAlias("ValorIr")
  private Double valorIr;

  @XStreamAlias("ValorCsll")
  private Double valorCsll;

  @XStreamAlias("IssRetido")
  private NFSeRpsInfoServicoValoresIssRetido issRetido;

  @XStreamAlias("ValorIss")
  private Double valorIss;

  @XStreamAlias("OutrasRetencoes")
  private Double outrasRetencoes;

  @XStreamAlias("Aliquota")
  private Double aliquota;

  @XStreamAlias("DescontoIncondicionado")
  private Double descontoIncondicionado;

  @XStreamAlias("DescontoCondicionado")
  private Double descontoCondicionado;

  public NFSeRpsInfoServicoValores() {
    super();
    valorDeducoes = 0.0;
    valorPis = 0.0;
    valorCofins = 0.0;
    valorInss = 0.0;
    valorIr = 0.0;
    valorCsll = 0.0;
    issRetido = NFSeRpsInfoServicoValoresIssRetido.NAO;
    valorIss = 0.0;
    outrasRetencoes = 0.0;
    valorIss = 0.0;
    aliquota = 0.0;

  }

  public Double getValorServicos() {
    return valorServicos;
  }

  public void setValorServicos(Double valorServicos) {
    this.valorServicos = ValidadorDecimal.tamanho15Com2CasasDecimais(valorServicos);
    calculoIss();
  }

  public Double getValorDeducoes() {
    return valorDeducoes;
  }

  public void setValorDeducoes(Double valorDeducoes) {
    this.valorDeducoes = ValidadorDecimal.tamanho15Com2CasasDecimais(valorDeducoes);
  }

  public Double getValorPis() {
    return valorPis;
  }

  public void setValorPis(Double valorPis) {
    this.valorPis = ValidadorDecimal.tamanho15Com2CasasDecimais(valorPis);
  }

  public Double getValorCofins() {
    return valorCofins;
  }

  public void setValorCofins(Double valorCofins) {
    this.valorCofins = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCofins);
  }

  public Double getValorInss() {
    return valorInss;
  }

  public void setValorInss(Double valorInss) {
    this.valorInss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorInss);
  }

  public Double getValorIr() {
    return valorIr;
  }

  public void setValorIr(Double valorIr) {
    this.valorIr = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIr);
  }

  public Double getValorCsll() {
    return valorCsll;
  }

  public void setValorCsll(Double valorCsll) {
    this.valorCsll = ValidadorDecimal.tamanho15Com2CasasDecimais(valorCsll);
  }

  public Double getOutrasRetencoes() {
    return outrasRetencoes;
  }

  public void setOutrasRetencoes(Double outrasRetencoes) {
    this.outrasRetencoes = ValidadorDecimal.tamanho15Com2CasasDecimais(outrasRetencoes);
  }

  public Double getValorIss() {
    return valorIss;
  }

  public void setValorIss(Double valorIss) {
    this.valorIss = ValidadorDecimal.tamanho15Com2CasasDecimais(valorIss);
  }

  public Double getAliquota() {
    return aliquota;
  }

  public void setAliquota(Double aliquota) {
    this.aliquota = ValidadorDecimal.tamanho5Com4CasasDecimais(aliquota / 100.0);
    calculoIss();
  }

  public Double getDescontoIncondicionado() {
    return descontoIncondicionado;
  }

  public void setDescontoIncondicionado(Double descontoIncondicionado) {
    this.descontoIncondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoIncondicionado);
  }

  public Double getDescontoCondicionado() {
    return descontoCondicionado;
  }

  public void setDescontoCondicionado(Double descontoCondicionado) {
    this.descontoCondicionado = ValidadorDecimal.tamanho15Com2CasasDecimais(descontoCondicionado);
  }

  public NFSeRpsInfoServicoValoresIssRetido getIssRetido() {
    return issRetido;
  }

  public void setIssRetido(NFSeRpsInfoServicoValoresIssRetido issRetido) {
    this.issRetido = issRetido;
  }

  private void calculoIss() {
    if (valorServicos != null && aliquota != null) {
      double calc = valorServicos * aliquota;
      valorIss = ValidadorDecimal.tamanho15Com2CasasDecimais(calc);
    }
  }
}
