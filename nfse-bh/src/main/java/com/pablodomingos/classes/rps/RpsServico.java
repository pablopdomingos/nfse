package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsServico {

  @XStreamAlias("Valores")
  @NotNull
  private RpsValores valores;

  @XStreamAlias("ItemListaServico")
  @NotNull
  @Size(min=1, max=5)
  private String codigoItemListaServico;

  @XStreamAlias("CodigoCnae")
  @Pattern(regexp = "\\d+")
  @Size(max=7)
  private String codigoCnae;

  @XStreamAlias("CodigoTributacaoMunicipio")
  @Size(min=1, max=20)
  private String codigoTributacaoMunicipio;

  @XStreamAlias("Discriminacao")
  @NotNull
  private String discriminacao;

  @XStreamAlias("CodigoMunicipio")
  @NotNull
  @Size(max=7)
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
