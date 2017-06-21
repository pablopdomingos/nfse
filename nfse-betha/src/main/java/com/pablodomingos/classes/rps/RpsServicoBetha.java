package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.pablodomingos.classes.rps.enums.ExigibilidadeIss;
import com.pablodomingos.classes.rps.enums.IssRetido;
import com.pablodomingos.classes.rps.enums.ResponsavelRetencao;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsServicoBetha extends AbstractRPS {

  @Element(name="Valores", required = false)
  @NotNull
  private RpsValoresBetha valores;

  @Element(name="IssRetido", required = false)
  @NotNull
  private IssRetido issRetido;

  @Element(name="ResponsavelRetencao", required = false)
  @NotNull
  private ResponsavelRetencao responsavelRetencao;

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

  @Element(name="Discriminacao", required = false)
  @NotNull
  @Size(min = 1, max = 2000)
  private String discriminacao;

  @Element(name="CodigoMunicipio", required = false)
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String codigoMunicipioIbge;

  @Element(name="CodigoPais", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 4)
  private String codigoPais;

  @Element(name="ExigibilidadeISS", required = false)
  @NotNull
  private ExigibilidadeIss exigibilidadeISS;

  @Element(name="MunicipioIncidencia", required = false)
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 7)
  private String municipioIncidencia;

  @Element(name="NumeroProcesso", required = false)
  @Size(max = 30)
  private String numeroProcesso;

  public RpsServicoBetha() {
  }

  public RpsServicoBetha(ServicoBuilder builder) {
    this.valores = new RpsValoresBetha(builder.getValores());
    this.codigoItemListaServico = builder.getCodigoItemListaServico();
    this.codigoCnae = builder.getCodigoCnae();
    this.codigoTributacaoMunicipio = builder.getCodigoTributacaoMunicipio();
    this.discriminacao = builder.getDiscriminacao();
    this.codigoMunicipioIbge = builder.getCodigoMunicipio();
    this.issRetido = builder.getValores().getIssRetido();
    this.exigibilidadeISS = builder.getExigibilidadeIss();
    this.codigoPais = builder.getCodigoPais();
    this.municipioIncidencia = builder.getMunicipioIncidencia();
    this.numeroProcesso = builder.getNumeroProcesso();
  }

  public RpsValoresBetha getValores() {
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

  public ResponsavelRetencao getResponsavelRetencao() {
    return responsavelRetencao;
  }

  public String getCodigoMunicipioIbge() {
    return codigoMunicipioIbge;
  }

  public String getCodigoPais() {
    return codigoPais;
  }

  public ExigibilidadeIss getExigibilidadeISS() {
    return exigibilidadeISS;
  }

  public String getMunicipioIncidencia() {
    return municipioIncidencia;
  }

  public String getNumeroProcesso() {
    return numeroProcesso;
  }
}
