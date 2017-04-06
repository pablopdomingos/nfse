package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.enums.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class RpsInfoBuilder extends AbstractBuilder {
  
  private String id = UUID.randomUUID().toString();
  private LocalDateTime dataEmissao;
  private NaturezaOperacao naturezaOperacao;
  private RegimeEspecialTributacao regimeEspecialTributacao;
  private OptanteSimplesNacional optanteSimplesNacional;
  private IncentivadorCultural incentivadorCultural;
  private RpsStatus status;
  private RpsTipo tipo;
  private String serie;
  private ServicoBuilder servico;
  private PrestadorBuilder prestador;
  private TomadorBuilder tomador;
  private IntermediarioBuilder intermediario;
  private ConstrucaoCivilBuilder contrucaoCivil;
  private String idSubstituido;
  private String serieSubstituido;


  public RpsInfoBuilder(String numeroRps) {
    this.id = numeroRps;
    this.dataEmissao = LocalDateTime.now();
    this.naturezaOperacao = NaturezaOperacao.TRIBUTACAO_MUNICIPIO;
    this.optanteSimplesNacional = OptanteSimplesNacional.NAO;
    this.incentivadorCultural = IncentivadorCultural.NAO;
    this.status = RpsStatus.NORMAL;
  }

  public RpsInfoBuilder comSerie(String serie) {
    this.serie = serie;
    return this;
  }
  
  public RpsInfoBuilder comTipo(RpsTipo tipo) {
    this.tipo = tipo;
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

  private RpsInfoBuilder comIdSubstituido(String idSubstituido) {
    this.idSubstituido = idSubstituido;
    return this;
  }

  public RpsInfoBuilder comSerieSubstituido(String serieSubstituido) {
    this.serieSubstituido = serieSubstituido;
    return this;
  }
  
  public RpsInfoBuilder comServico(ServicoBuilder servico) {
    this.servico = servico;
    return this;
  }
  
  public RpsInfoBuilder comPrestador(PrestadorBuilder prestador){
    this.prestador = prestador;
    return this;
  }
  
  public RpsInfoBuilder comTomador(TomadorBuilder tomador){
    this.tomador = tomador;
    return this;
  }
  
  public RpsInfoBuilder comIntermediario(IntermediarioBuilder intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public RpsInfoBuilder comConstrucaoCivil (ConstrucaoCivilBuilder contrucaoCivil){
    this.contrucaoCivil = contrucaoCivil;
    return this;
  }
  
  public String getId() {
    return id;
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

  public RpsTipo getTipo() {
    return tipo;
  }

  public String getSerie() {
    return serie;
  }

  public ServicoBuilder getServico() {
    return servico;
  }

  public PrestadorBuilder getPrestador() {
    return prestador;
  }

  public TomadorBuilder getTomador() {
    return tomador;
  }

  public IntermediarioBuilder getIntermediario() {
    return intermediario;
  }

  public ConstrucaoCivilBuilder getContrucaoCivil() {
    return contrucaoCivil;
  }

  public String getIdSubstituido() {
    return idSubstituido;
  }

  public String getSerieSubstituido() {
    return serieSubstituido;
  }
}

