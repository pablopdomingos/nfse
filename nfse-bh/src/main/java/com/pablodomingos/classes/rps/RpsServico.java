package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsServico {

  @XStreamAlias("Valores")
  private RpsValores valores;

  @XStreamAlias("ItemListaServico")
  private String codigoItemListaServico;

  @XStreamAlias("CodigoCnae")
  private String codigoCnae;

  @XStreamAlias("CodigoTributacaoMunicipio")
  private String codigoTributacaoMunicipio;

  @XStreamAlias("Discriminacao")
  private String discriminacao;

  @XStreamAlias("CodigoMunicipio")
  private String codigoMunicipioIbge;

  public RpsServico(ServicoBuilder builder) {
    this.valores = builder.getValores();
    this.codigoItemListaServico = builder.getCodigoItemListaServico();
    this.codigoCnae = builder.getCodigoCnae();
    this.codigoTributacaoMunicipio = builder.getCodigoTributacaoMunicipio();
    this.discriminacao = builder.getDiscriminacao();
    this.codigoMunicipioIbge = builder.getCodigoMunicipio();
  }

  public RpsValores getValores() {
    return valores;
  }

  public String getCodigoItemListaServico() {
    return codigoItemListaServico;
  }

  public String getCodigoCnae() {
    return codigoCnae;
  }

  public String getDiscriminacao() {
    return discriminacao;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipioIbge;
  }

  public String getCodigoTributacaoMunicipio() {
    return codigoTributacaoMunicipio;
  }

}
