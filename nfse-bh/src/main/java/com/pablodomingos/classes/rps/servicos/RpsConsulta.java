package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.RpsIdentificacao;
import com.pablodomingos.classes.rps.RpsPrestador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="ConsultarNfseRpsEnvio")
public class RpsConsulta extends AbstractServiceBHISS {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="IdentificacaoRps")
  @NotNull
  private RpsIdentificacao identificacaoRps;

  @Element(name="Prestador")
  @NotNull
  private RpsPrestador prestador;

  public RpsConsulta(RpsIdentificacao identificacaoRps, RpsPrestador prestador) {
    super();
    this.identificacaoRps = identificacaoRps;
    this.prestador = prestador;
  }

  public RpsIdentificacao getIdentificacaoRps() {
    return identificacaoRps;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }
}
