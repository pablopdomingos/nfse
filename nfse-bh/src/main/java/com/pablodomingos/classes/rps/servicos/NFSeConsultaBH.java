package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.PeriodoEmissaoBH;
import com.pablodomingos.classes.rps.RpsIntermediarioBH;
import com.pablodomingos.classes.rps.RpsPrestadorBH;
import com.pablodomingos.classes.rps.RpsTomadorIdentificacaoBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Root(name="ConsultarNfseEnvio")
public class NFSeConsultaBH extends AbstractServiceBH {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBH prestador;

  @Element(name="NumeroNfse", required = false)
  @Size(min = 15, max = 15)
  private String numeroNFSe;
  
  @Element(name="PeriodoEmissao")
  @NotNull
  private PeriodoEmissaoBH periodoEmissao;
  
  @Element(name="Tomador", required = false)
  private RpsTomadorIdentificacaoBH tomador;

  @Element(name="IntermediarioServico", required = false)
  private RpsIntermediarioBH intermediario;
  
  public NFSeConsultaBH(RpsPrestadorBH prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super();
    this.prestador = prestador;
    this.periodoEmissao = new PeriodoEmissaoBH(dataInicial, dataFinal);
  }

  public NFSeConsultaBH comTomador(RpsTomadorIdentificacaoBH tomador){
    this.tomador = tomador;
    return this;
  }
  
  public NFSeConsultaBH comIntermediario(RpsIntermediarioBH intermediario){
    this.intermediario = intermediario;
    return this;
  }
  
  public RpsPrestadorBH getPrestador() {
    return prestador;
  }

}
