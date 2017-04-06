package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.pablodomingos.classes.rps.enums.ExigibilidadeIss;
import com.pablodomingos.classes.rps.enums.IssRetido;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsServico extends AbstractRPS {

  @Element(name="Valores")
  @NotNull
  private RpsValores valores;

  @Element(name="IssRetido")
  @NotNull
  private IssRetido issRetido;

  @Element(name="ItemListaServico")
  @NotNull
  @Size(min = 1, max = 5)
  private String codigoItemListaServico;

  @Element(name="CodigoCnae", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoCnae;

  @Element(name="CodigoTributacaoMunicipio", required = false)
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

  @Element(name="CodigoPais", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 4)
  private String codigoPais = "1058"; //fixo Brasil

  @Element(name="ExigibilidadeISS")
  @NotNull
  private ExigibilidadeIss exigibilidadeISS;

  @Element(name="MunicipioIncidencia", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String municipioIncidencia;

  @Element(name="NumeroProcesso", required = false)
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
