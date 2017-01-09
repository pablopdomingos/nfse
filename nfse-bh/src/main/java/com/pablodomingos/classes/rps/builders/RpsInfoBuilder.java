package com.pablodomingos.classes.rps.builders;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pablodomingos.classes.rps.RpsDadosContrucaoCivil;
import com.pablodomingos.classes.rps.RpsIdentificacaoRps;
import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.classes.rps.RpsInfo;
import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.rps.enums.RpsSerie;
import com.pablodomingos.classes.rps.enums.RpsStatus;
import com.pablodomingos.classes.rps.enums.RpsTipo;

public class RpsInfoBuilder extends AbstractBuilder<RpsInfo>{
  
  private String id = UUID.randomUUID().toString();
  private RpsIdentificacaoRps identificacaoRps ;
  private LocalDateTime dataEmissao;
  private NaturezaOperacao naturezaOperacao;
  private RegimeEspecialTributacao regimeEspecialTributacao;
  private OptanteSimplesNacional optanteSimplesNacional;
  private IncentivadorCultural incentivadorCultural;
  private RpsStatus status;
  private RpsServico servico;
  private RpsPrestador prestador;
  private RpsTomador tomador;
  private RpsIntermediario intermediario;
  private RpsDadosContrucaoCivil contrucaoCivil;
  
  public RpsInfoBuilder(String numeroRps) {
    this.identificacaoRps = new RpsIdentificacaoRps(numeroRps);
    this.dataEmissao = LocalDateTime.now();
    this.naturezaOperacao = NaturezaOperacao.TRIBUTACAO_MUNICIPIO;
    this.optanteSimplesNacional = OptanteSimplesNacional.NAO;
    this.incentivadorCultural = IncentivadorCultural.NAO;
    this.status = RpsStatus.NORMAL;
  }

  public RpsInfoBuilder comSerie(RpsSerie serie) {
    this.identificacaoRps.setSerie(serie);
    return this;
  }
  
  public RpsInfoBuilder comTipo(RpsTipo tipo) {
    this.identificacaoRps.setTipo(tipo);
    return this;
  }
  
  public RpsInfoBuilder comId(String id) {
    this.id = id;
    return this;
  }

  public RpsInfoBuilder comNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
    return this;
  }
  
  public RpsInfoBuilder comRegimeEspecialTributacao(RegimeEspecialTributacao regimeEspecialTributacao) {
    this.regimeEspecialTributacao = regimeEspecialTributacao;
    return this;
  }
  
  public RpsInfoBuilder optanteSimplesNacional(boolean optanteSimplesNacional) {
    this.optanteSimplesNacional = optanteSimplesNacional ? OptanteSimplesNacional.SIM : OptanteSimplesNacional.NAO;
    return this;
  }
  
  public RpsInfoBuilder incentivadorCultural(boolean incentivadorCultural) {
    this.incentivadorCultural = incentivadorCultural ? IncentivadorCultural.SIM : IncentivadorCultural.NAO;
    return this;
  }
  
  public RpsInfoBuilder comStatus(RpsStatus rpsStatus) {
    this.status = rpsStatus;
    return this;
  }

  public RpsInfoBuilder comServico(RpsServico servico) {
    this.servico = servico;
    return this;
  }
  
  public RpsInfoBuilder comPrestador(RpsPrestador prestador){
    this.prestador = prestador;
    return this;
  }
  
  public RpsInfoBuilder comTomador(RpsTomador tomador){
    this.tomador = tomador;
    return this;
  }
  
  public RpsInfoBuilder comIntermediario(RpsIntermediario intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public RpsInfoBuilder comConstrucaoCivil (RpsDadosContrucaoCivil contrucaoCivil){
    this.contrucaoCivil = contrucaoCivil;
    return this;
  }
  
  protected RpsInfo buildInternal() {
    return new RpsInfo(this);
  }

  public String getId() {
    return id;
  }

  public RpsIdentificacaoRps getIdentificacaoRps() {
    return identificacaoRps;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public NaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public RpsStatus getStatus() {
    return status;
  }

  public RpsServico getServico() {
    return servico;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }

  public RpsTomador getTomador() {
    return tomador;
  }

  public RpsIntermediario getIntermediario() {
    return intermediario;
  }

  public RpsDadosContrucaoCivil getContrucaoCivil() {
    return contrucaoCivil;
  }
  
}

