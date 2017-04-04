package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.pablodomingos.classes.rps.enums.ExigibilidadeIss;
import com.pablodomingos.classes.rps.enums.IssRetido;
import com.pablodomingos.util.DoubleUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsServico extends AbstractRPS {

  @XStreamAlias("Valores")
  @NotNull
  private RpsValores valores;

  @XStreamAlias("IssRetido")
  @NotNull
  private IssRetido issRetido;

  @XStreamAlias("ItemListaServico")
  @NotNull
  @Size(min = 1, max = 5)
  private String codigoItemListaServico;

  @XStreamAlias("CodigoCnae")
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoCnae;

  @XStreamAlias("CodigoTributacaoMunicipio")
  @Size(min = 1, max = 20)
  private String codigoTributacaoMunicipio;

  @XStreamAlias("Discriminacao")
  @NotNull
  @Size(min = 1, max = 2000)
  private String discriminacao;

  @XStreamAlias("CodigoMunicipio")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoMunicipioIbge;

  @XStreamAlias("CodigoPais")
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 4)
  private String codigoPais = "1058"; //fixo Brasil

  @XStreamAlias("ExigibilidadeISS")
  @NotNull
  private ExigibilidadeIss exigibilidadeISS;

  @XStreamAlias("MunicipioIncidencia")
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String municipioIncidencia;

  @XStreamAlias("NumeroProcesso")
  @Size(max = 30)
  private String numeroProcesso;

  public RpsServico(ServicoBuilder builder) {
    this.valores = new RpsValores(builder.getValores());
    this.codigoItemListaServico = builder.getCodigoItemListaServico();
    this.codigoCnae = builder.getCodigoCnae();
    this.codigoTributacaoMunicipio = builder.getCodigoTributacaoMunicipio();
    this.discriminacao = builder.getDiscriminacao();
    this.codigoMunicipioIbge = builder.getCodigoMunicipio();
    this.issRetido = builder.getValores().getIssRetido();
    this.exigibilidadeISS = builder.getExigibilidadeIss();
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

  public IssRetido getIssRetido() {
    return issRetido;
  }
}
