package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.PeriodoEmissao;
import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacao;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Root(name="ConsultarNfseEnvio")
public class NFSeConsulta extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestador prestador;

  @Element(name="NumeroNfse", required = false)
  @Size(min = 15, max = 15)
  private String numeroNFSe;
  
  @Element(name="PeriodoEmissao")
  @NotNull
  private PeriodoEmissao periodoEmissao;
  
  @Element(name="Tomador", required = false)
  private RpsTomadorIdentificacao tomador;

  @Element(name="IntermediarioServico", required = false)
  private RpsIntermediario intermediario;
  
  public NFSeConsulta(RpsPrestador prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super();
    this.prestador = prestador;
    this.periodoEmissao = new PeriodoEmissao(dataInicial, dataFinal);
  }

  public NFSeConsulta comTomador(RpsTomadorIdentificacao tomador){
    this.tomador = tomador;
    return this;
  }
  
  public NFSeConsulta comIntermediario(RpsIntermediario intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public RpsPrestador getPrestador() {
    return prestador;
  }

}
