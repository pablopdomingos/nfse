package com.pablodomingos.classes.rps;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.builders.ValoresBuilder;
import com.pablodomingos.classes.rps.enums.IssRetido;
import com.pablodomingos.conversores.DoubleConversor;
import com.pablodomingos.util.DoubleUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamConverter(DoubleConversor.class)
public class RpsValores extends AbstractRPS {

  @XStreamAlias("ValorServicos")
  @NotNull
  @Digits(integer=13, fraction=2)
  @DecimalMin("0.01")
  private Double valorServicos;

  @XStreamAlias("ValorDeducoes")
  @Digits(integer=13, fraction=2)
  private Double valorDeducoes;

  @XStreamAlias("ValorPis")
  @Digits(integer=13, fraction=2)
  private Double valorPis;

  @XStreamAlias("ValorCofins")
  @Digits(integer=13, fraction=2)
  private Double valorCofins;

  @XStreamAlias("ValorInss")
  @Digits(integer=13, fraction=2)
  private Double valorInss;

  @XStreamAlias("ValorIr")
  @Digits(integer=13, fraction=2)
  private Double valorIr;

  @XStreamAlias("ValorCsll")
  @Digits(integer=13, fraction=2)
  private Double valorCsll;

  @XStreamOmitField
  @Digits(integer=13, fraction=2) //fixme
  private Double valorIssRetido;
  
  @XStreamAlias("OutrasRetencoes")
  @Digits(integer=13, fraction=2)
  private Double outrasRetencoes;

  @XStreamAlias("ValorIss")
  @Digits(integer=13, fraction=2)
  private Double valorIss;

  @XStreamOmitField
  @Digits(integer=13, fraction=2) //fixme
  private Double baseCalculo;
  
  @XStreamAlias("Aliquota")
  @Digits(integer=13, fraction=2)
  private Double aliquota;

  @XStreamOmitField
  @NotNull//fixme
  @Digits(integer=13, fraction=2)
  @DecimalMin("0.01")
  private Double valorLiquido;
  
  @XStreamAlias("DescontoIncondicionado")
  @Digits(integer=13, fraction=2)
  private Double descontoIncondicionado;

  @XStreamAlias("DescontoCondicionado")
  @Digits(integer=13, fraction=2)
  private Double descontoCondicionado;

  public RpsValores(ValoresBuilder builder) {
    this.valorServicos = builder.getValorServicos();
    this.valorDeducoes = builder.getValorDeducoes();
    this.valorPis = builder.getValorPis();
    this.valorCofins = builder.getValorCofins();
    this.valorInss = builder.getValorInss();
    this.valorIr = builder.getValorIr();
    this.valorCsll = builder.getValorCsll();
    this.outrasRetencoes = builder.getOutrasRetencoes();
    this.aliquota = builder.getAliquota();
    this.descontoIncondicionado = builder.getDescontoIncondicionado();
    this.descontoCondicionado = builder.getDescontoCondicionado();

    if(builder.getIssRetido().equals(IssRetido.NAO)){
      this.valorIss = DoubleUtil.arredondarDuasCasas(calcularIss());
    }else {
      this.valorIssRetido = DoubleUtil.arredondarDuasCasas(calcularIss());
    }

    this.baseCalculo = DoubleUtil.arredondarDuasCasas(calcularBaseCalculo());
    this.valorLiquido = DoubleUtil.arredondarDuasCasas(calcularValorLiquido());
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

  public Double getValorIssRetido() {
    return valorIssRetido;
  }

  public Double getBaseCalculo() {
    return baseCalculo;
  }

  public Double getValorLiquido() {
    return valorLiquido;
  }

  private Double calcularIss() {
      return this.valorServicos * this.aliquota;
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
