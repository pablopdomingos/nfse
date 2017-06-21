package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.RpsIdentificacaoBetha;
import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;

@Root(name="ConsultarNfseRpsEnvio")
public class RpsConsultaBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="IdentificacaoRps")
  @NotNull
  private RpsIdentificacaoBetha identificacaoRps;

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBetha prestador;

  public RpsConsultaBetha(RpsIdentificacaoBetha identificacaoRps, RpsPrestadorBetha prestador) {
    super();
    this.identificacaoRps = identificacaoRps;
    this.prestador = prestador;
  }

  public RpsIdentificacaoBetha getIdentificacaoRps() {
    return identificacaoRps;
  }

  public RpsPrestadorBetha getPrestador() {
    return prestador;
  }
}
