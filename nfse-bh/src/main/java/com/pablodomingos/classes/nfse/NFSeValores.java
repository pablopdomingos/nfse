package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.builders.ValoresBuilder;
import com.pablodomingos.classes.nfse.enums.IssRetido;
import com.pablodomingos.conversores.DoubleConversor;
import com.pablodomingos.validadores.ValidadorDecimal;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(DoubleConversor.class)
public class NFSeValores {

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
  private IssRetido issRetido;

  @XStreamAlias("ValorIss")
  private Double valorIss;

  @XStreamAlias("ValorIssRetido")
  private Double valorIssRetido;
  
  @XStreamAlias("OutrasRetencoes")
  private Double outrasRetencoes;

  @XStreamAlias("BaseCalculo")
  private Double baseCalculo;
  
  @XStreamAlias("Aliquota")
  private Double aliquota;

  @XStreamAlias("ValorLiquidoNfse")
  private Double valorLiquido;
  
  @XStreamAlias("DescontoIncondicionado")
  private Double descontoIncondicionado;

  @XStreamAlias("DescontoCondicionado")
  private Double descontoCondicionado;

  public NFSeValores(ValoresBuilder builder) {
    this.valorServicos = builder.getValorServicos();
    this.valorDeducoes = builder.getValorDeducoes();
    this.valorPis = builder.getValorPis();
    this.valorCofins = builder.getValorCofins();
    this.valorInss = builder.getValorInss();
    this.valorIr = builder.getValorIr();
    this.valorCsll = builder.getValorCsll();
    this.issRetido = builder.getIssRetido();
    this.outrasRetencoes = builder.getOutrasRetencoes();
    this.aliquota = builder.getAliquota();
    this.descontoIncondicionado = builder.getDescontoIncondicionado();
    this.descontoCondicionado = builder.getDescontoCondicionado();
    
    if(this.issRetido.equals(IssRetido.NAO)){
      this.valorIss = calcularIss();
    }else {
      this.valorIssRetido = calcularIss();
    }
    
    this.baseCalculo = calcularBaseCalculo();
    this.valorLiquido = calcularValorLiquido();
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

  public Double getOutrasRetencoes() {
    return outrasRetencoes;
  }

  public Double getValorIss() {
    return valorIss;
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

  public IssRetido getIssRetido() {
    return issRetido;
  }

  private Double calcularIss() {
      return ValidadorDecimal.tamanho15Com2CasasDecimais(this.valorServicos * this.aliquota);
  }
  
  private Double calcularValorLiquido() {
    return  this.valorServicos - 
            (this.valorPis == null ? 0 : this.valorPis) -
            (this.valorCofins == null ? 0 : this.valorCofins) -
            (this.valorInss == null ? 0 : this.valorInss) -
            (this.valorIr == null ? 0 : this.valorIr) -
            (this.valorCsll == null ? 0 : this.valorCsll) -
            (this.outrasRetencoes == null ? 0 : this.outrasRetencoes) -
            (this.valorIssRetido == null ? 0 : this.valorIssRetido) -
            (this.descontoCondicionado == null ? 0 : this.descontoCondicionado) -
            (this.descontoIncondicionado == null ? 0 : this.descontoIncondicionado);
  }
  
  private Double calcularBaseCalculo() {
    return  this.valorServicos - 
            (this.valorDeducoes == null ? 0 : this.valorDeducoes) -
            (this.descontoIncondicionado == null ? 0 : this.descontoIncondicionado);
  }
  

}
