package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsServicoBH extends AbstractRPS {

  @Element(name="Valores")
  @NotNull
  private RpsValoresBH valores;

  @Element(name="ItemListaServico")
  @NotNull
  @Size(min = 1, max = 5)
  private String codigoItemListaServico;

  @Element(name="CodigoCnae")
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoCnae;

  @Element(name="CodigoTributacaoMunicipio")
  @Size(min = 1, max = 20)
  private String codigoTributacaoMunicipio;

  @Element(name="Discriminacao")
  @NotNull
  @Size(min = 1, max = 2000)
  private String discriminacao;

  @Element(name="CodigoMunicipio")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoMunicipioIbge;

  public RpsServicoBH(ServicoBuilder builder) {
    this.valores = new RpsValoresBH(builder.getValores());
    this.codigoItemListaServico = builder.getCodigoItemListaServico();
    this.codigoCnae = builder.getCodigoCnae();
    this.codigoTributacaoMunicipio = builder.getCodigoTributacaoMunicipio();
    this.discriminacao = builder.getDiscriminacao();
    this.codigoMunicipioIbge = builder.getCodigoMunicipio();
  }

  public RpsValoresBH getValores() {
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
