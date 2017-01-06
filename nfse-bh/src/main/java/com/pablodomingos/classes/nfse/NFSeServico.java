package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.builders.ServicoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeServico {

  @XStreamAlias("Valores")
  private NFSeValores valores;

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

  public NFSeServico(ServicoBuilder builder) {
    this.valores = builder.getValores();
    this.codigoItemListaServico = builder.getCodigoItemListaServico();
    this.codigoCnae = builder.getCodigoCnae();
    this.codigoTributacaoMunicipio = builder.getCodigoTributacaoMunicipio();
    this.discriminacao = builder.getDiscriminacao();
    this.codigoMunicipioIbge = builder.getCodigoMunicipio();
  }

  public NFSeValores getValores() {
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
