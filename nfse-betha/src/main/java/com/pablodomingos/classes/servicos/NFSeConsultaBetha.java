package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.PeriodoEmissaoBetha;
import com.pablodomingos.classes.rps.RpsIntermediarioBetha;
import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacaoBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Root(name="ConsultarNfseEnvio")
public class NFSeConsultaBetha<T> extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBetha prestador;

  @Element(name="NumeroNfse", required = false)
  @Size(min = 15, max = 15)
  private String numeroNFSe;
  
  @Element(name="PeriodoEmissao")
  @NotNull
  private PeriodoEmissaoBetha periodoEmissao;
  
  @Element(name="Tomador", required = false)
  private RpsTomadorIdentificacaoBetha tomador;

  @Element(name="IntermediarioServico", required = false)
  private RpsIntermediarioBetha intermediario;

  @Element(name="Pagina", required = false)
  private Integer pagina;
  
  public NFSeConsultaBetha(RpsPrestadorBetha prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super();
    this.prestador = prestador;
    this.periodoEmissao = new PeriodoEmissaoBetha(dataInicial, dataFinal);
  }

  public RpsPrestadorBetha getPrestador() {
    return prestador;
  }

  public void setPrestador(RpsPrestadorBetha prestador) {
    this.prestador = prestador;
  }

  public String getNumeroNFSe() {
    return numeroNFSe;
  }

  public void setNumeroNFSe(String numeroNFSe) {
    this.numeroNFSe = numeroNFSe;
  }

  public PeriodoEmissaoBetha getPeriodoEmissao() {
    return periodoEmissao;
  }

  public void setPeriodoEmissao(PeriodoEmissaoBetha periodoEmissao) {
    this.periodoEmissao = periodoEmissao;
  }

  public RpsTomadorIdentificacaoBetha getTomador() {
    return tomador;
  }

  public void setTomador(RpsTomadorIdentificacaoBetha tomador) {
    this.tomador = tomador;
  }

  public RpsIntermediarioBetha getIntermediario() {
    return intermediario;
  }

  public void setIntermediario(RpsIntermediarioBetha intermediario) {
    this.intermediario = intermediario;
  }

  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }
}
