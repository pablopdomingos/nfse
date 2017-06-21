package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import java.time.LocalDateTime;

public class InfNfse {

  @Element(name = "Numero", required = false)
  private String numero;


  @Element(name = "CodigoVerificacao", required = false)
  private String codigoVerificacao;


  @Element(name = "DataEmissao", required = false)
  private LocalDateTime dataEmissao;


  @Element(name = "OutrasInformacoes", required = false)
  private String outrasInformacoes;


  @Element(name = "ValoresNfse", required = false)
  private RpsValoresBetha valoresNfse;

  @Element(name = "ValorCredito", required = false)
  private Double valorCredito;

  @Element(name = "PrestadorServico", required = false)
  private PrestadorServicoBetha prestadorServico;


  @Element(name = "OrgaoGerador", required = false)
  private OrgaoGeradorBetha orgaoGerador;


  @Element(name = "DeclaracaoPrestacaoServico", required = false)
  private RpsBetha declaracaoPrestacaoServico;

  public String getNumero() {
    return numero;
  }

  public String getCodigoVerificacao() {
    return codigoVerificacao;
  }

  public LocalDateTime getDataEmissao() {
    return dataEmissao;
  }

  public String getOutrasInformacoes() {
    return outrasInformacoes;
  }

  public RpsValoresBetha getValoresNfse() {
    return valoresNfse;
  }

  public Double getValorCredito() {
    return valorCredito;
  }

  public PrestadorServicoBetha getPrestadorServico() {
    return prestadorServico;
  }

  public OrgaoGeradorBetha getOrgaoGerador() {
    return orgaoGerador;
  }

  public RpsBetha getDeclaracaoPrestacaoServico() {
    return declaracaoPrestacaoServico;
  }
}
