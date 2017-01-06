package com.pablodomingos.classes.nfse.builders;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pablodomingos.classes.nfse.NFSePrestador;
import com.pablodomingos.classes.nfse.NFSeRpsInfo;
import com.pablodomingos.classes.nfse.NFSeRpsInfoIdentificacaoRps;
import com.pablodomingos.classes.nfse.NFSeServico;
import com.pablodomingos.classes.nfse.NFSeIntermediario;
import com.pablodomingos.classes.nfse.NFSeTomador;
import com.pablodomingos.classes.nfse.enums.IncentivadorCultural;
import com.pablodomingos.classes.nfse.enums.NaturezaOperacao;
import com.pablodomingos.classes.nfse.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.nfse.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.nfse.enums.RpsSerie;
import com.pablodomingos.classes.nfse.enums.RpsStatus;
import com.pablodomingos.classes.nfse.enums.RpsTipo;
import com.pablodomingos.validadores.ValidadorString;

public class RpsInfoBuilder{

  private String id = UUID.randomUUID().toString();
  private NFSeRpsInfoIdentificacaoRps identificacaoRps ;
  private LocalDateTime dataEmissao;
  private NaturezaOperacao naturezaOperacao;
  private RegimeEspecialTributacao regimeEspecialTributacao;
  private OptanteSimplesNacional optanteSimplesNacional;
  private IncentivadorCultural incentivadorCultural;
  private RpsStatus status;
  private NFSeServico servico;
  private NFSePrestador prestador;
  private NFSeTomador tomador;
  private NFSeIntermediario intermediario;
  
  public RpsInfoBuilder(String numeroRps) {
    if (numeroRps == null || numeroRps.isEmpty()) {
      throw new IllegalArgumentException("Numero da RPS não pode ser nulo");
    }
    this.identificacaoRps = new NFSeRpsInfoIdentificacaoRps(numeroRps);
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
    this.id = ValidadorString.comTamanhoMaximoEMinimo(255, 1, id, "Tag ID");
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

  public RpsInfoBuilder comServico(NFSeServico servico) {
    this.servico = servico;
    return this;
  }
  
  public RpsInfoBuilder comPrestador(NFSePrestador prestador){
    this.prestador = prestador;
    return this;
  }
  
  public RpsInfoBuilder comTomador(NFSeTomador tomador){
    this.tomador = tomador;
    return this;
  }
  
  public RpsInfoBuilder comIntermediario(NFSeIntermediario intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public NFSeRpsInfo build() {
    return new NFSeRpsInfo(this);
  }

  public String getId() {
    return id;
  }

  public NFSeRpsInfoIdentificacaoRps getIdentificacaoRps() {
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

  public NFSeServico getServico() {
    return servico;
  }

  public NFSePrestador getPrestador() {
    return prestador;
  }

  public NFSeTomador getTomador() {
    return tomador;
  }

  public NFSeIntermediario getIntermediario() {
    return intermediario;
  }
  
  
}

