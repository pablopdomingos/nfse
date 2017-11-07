package com.pablodomingos.classes.rps.servicos;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import com.pablodomingos.classes.rps.RpsIdentificacao;
import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.conversores.LocalDateConversor;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class InfNFSe {
  @XStreamAlias("Id")
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("Numero")
  private String numero;

  @XStreamAlias("CodigoVerificacao")
  private String codigoVerificacao;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime dataEmissao;

  @XStreamAlias("IdentificacaoRps")
  private RpsIdentificacao identificacaoRps;

  @XStreamAlias("DataEmissaoRps")
  @XStreamConverter(LocalDateConversor.class)
  private LocalDate dataEmissaoRps;

  @XStreamAlias("NaturezaOperacao")
  private NaturezaOperacao naturezaOperacao;

  @XStreamAlias("RegimeEspecialTributacao")
  private RegimeEspecialTributacao regimeEspecialTributacao;

  @XStreamAlias("OptanteSimplesNacional")
  private OptanteSimplesNacional optanteSimplesNacional;

  @XStreamAlias("IncentivadorCultural")
  private IncentivadorCultural incentivadorCultural;

  @XStreamAlias("Competencia")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime competencia;

  @XStreamAlias("NfseSubstituida")
  private String nfseSubstituida;

  @XStreamAlias("OutrasInformacoes")
  private String outrasInformacoes;

  @XStreamAlias("Servico")
  @NotNull
  private RpsServico servico;

  @XStreamAlias("PrestadorServico")
  @NotNull
  private PrestadorServico prestadorServico;

  @XStreamAlias("TomadorServico")
  private RpsTomador tomadorServico;

  @XStreamAlias("OrgaoGerador")
  private OrgaoGerador orgaoGerador;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCodigoVerificacao() {
    return codigoVerificacao;
  }

  public void setCodigoVerificacao(String codigoVerificacao) {
    this.codigoVerificacao = codigoVerificacao;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(LocalDateTime dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public RpsIdentificacao getIdentificacaoRps() {
    return identificacaoRps;
  }

  public void setIdentificacaoRps(RpsIdentificacao identificacaoRps) {
    this.identificacaoRps = identificacaoRps;
  }

  public LocalDate getDataEmissaoRps() {
    return dataEmissaoRps;
  }

  public void setDataEmissaoRps(LocalDate dataEmissaoRps) {
    this.dataEmissaoRps = dataEmissaoRps;
  }

  public NaturezaOperacao getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public void setNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
  }

  public RegimeEspecialTributacao getRegimeEspecialTributacao() {
    return regimeEspecialTributacao;
  }

  public void setRegimeEspecialTributacao(RegimeEspecialTributacao regimeEspecialTributacao) {
    this.regimeEspecialTributacao = regimeEspecialTributacao;
  }

  public OptanteSimplesNacional getOptanteSimplesNacional() {
    return optanteSimplesNacional;
  }

  public void setOptanteSimplesNacional(OptanteSimplesNacional optanteSimplesNacional) {
    this.optanteSimplesNacional = optanteSimplesNacional;
  }

  public IncentivadorCultural getIncentivadorCultural() {
    return incentivadorCultural;
  }

  public void setIncentivadorCultural(IncentivadorCultural incentivadorCultural) {
    this.incentivadorCultural = incentivadorCultural;
  }

  public LocalDateTime getCompetencia() {
    return competencia;
  }

  public void setCompetencia(LocalDateTime competencia) {
    this.competencia = competencia;
  }

  public String getOutrasInformacoes() {
    return outrasInformacoes;
  }

  public void setOutrasInformacoes(String outrasInformacoes) {
    this.outrasInformacoes = outrasInformacoes;
  }

  public RpsServico getServico() {
    return servico;
  }

  public void setServico(RpsServico servico) {
    this.servico = servico;
  }

  public RpsTomador getTomadorServico() {
    return tomadorServico;
  }

  public void setTomadorServico(RpsTomador tomadorServico) {
    this.tomadorServico = tomadorServico;
  }

  public String getNfseSubstituida() {
    return nfseSubstituida;
  }

  public String getNfseSubstituidaFormatada() {
    if (nfseSubstituida != null) {
      String ano = nfseSubstituida.substring(0, 4);
      Integer digito = Integer.valueOf(nfseSubstituida.substring(5, nfseSubstituida.length()));
      return ano + "/" + digito.toString();
    }

    return nfseSubstituida;
  }

  public void setNfseSubstituida(String nfseSubstituida) {
    this.nfseSubstituida = nfseSubstituida;
  }

  public OrgaoGerador getOrgaoGerador() {
    return orgaoGerador;
  }

  public void setOrgaoGerador(OrgaoGerador orgaoGerador) {
    this.orgaoGerador = orgaoGerador;
  }

  public PrestadorServico getPrestadorServico() {
    return prestadorServico;
  }

  public void setPrestadorServico(PrestadorServico prestadorServico) {
    this.prestadorServico = prestadorServico;
  }

}
