package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.RpsIdentificacaoBH;
import com.pablodomingos.classes.rps.RpsPrestadorBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="ConsultarNfseRpsEnvio")
public class RpsConsultaBH extends AbstractServiceBH {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="IdentificacaoRps")
  @NotNull
  private RpsIdentificacaoBH identificacaoRps;

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBH prestador;

  public RpsConsultaBH(RpsIdentificacaoBH identificacaoRps, RpsPrestadorBH prestador) {
    super();
    this.identificacaoRps = identificacaoRps;
    this.prestador = prestador;
  }

  public RpsIdentificacaoBH getIdentificacaoRps() {
    return identificacaoRps;
  }

  public RpsPrestadorBH getPrestador() {
    return prestador;
  }
}
