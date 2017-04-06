package com.pablodomingos.classes.rps.servicos;

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
public class NFSeConsultaBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBetha prestador;

  @Element(name="NumeroNfse", required = false)
  @Size(min = 15, max = 15)
  private String numeroNFSe;
  
  @Element(name="PeriodoEmissaoBetha")
  @NotNull
  private PeriodoEmissaoBetha periodoEmissao;
  
  @Element(name="Tomador", required = false)
  private RpsTomadorIdentificacaoBetha tomador;

  @Element(name="IntermediarioServico", required = false)
  private RpsIntermediarioBetha intermediario;
  
  public NFSeConsultaBetha(RpsPrestadorBetha prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super();
    this.prestador = prestador;
    this.periodoEmissao = new PeriodoEmissaoBetha(dataInicial, dataFinal);
  }

  public NFSeConsultaBetha comTomador(RpsTomadorIdentificacaoBetha tomador){
    this.tomador = tomador;
    return this;
  }
  
  public NFSeConsultaBetha comIntermediario(RpsIntermediarioBetha intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public RpsPrestadorBetha getPrestador() {
    return prestador;
  }

}
