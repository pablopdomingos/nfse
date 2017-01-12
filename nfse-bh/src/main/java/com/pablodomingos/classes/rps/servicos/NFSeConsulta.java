package com.pablodomingos.classes.rps.servicos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.PeriodoEmissao;
import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacao;
<<<<<<< HEAD
import com.thoughtworks.xstream.XStream;
=======
>>>>>>> 043835f05c7e265fd3b9ea061abbef840b63aa14
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseEnvio")
public class NFSeConsulta extends AbstractService{

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("Prestador")
  @NotNull
  private RpsPrestador prestador;

  @XStreamAlias("NumeroNfse")
  @Size(min = 15, max = 15)
  private String numeroNFSe;
  
  @XStreamAlias("PeriodoEmissao")
  @NotNull
  private PeriodoEmissao periodoEmissao;
  
  @XStreamAlias("Tomador")
  private RpsTomadorIdentificacao tomador;

  @XStreamAlias("IntermediarioServico")
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
