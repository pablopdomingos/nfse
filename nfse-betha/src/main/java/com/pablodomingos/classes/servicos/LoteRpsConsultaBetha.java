package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Root(name="ConsultarLoteRpsEnvio")
public class LoteRpsConsultaBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBetha prestador;

  @Element(name="Protocolo")
  @NotNull
  @Size(max = 50)
  private String numeroProtocolo;
  
  public LoteRpsConsultaBetha(String numeroProtocolo, RpsPrestadorBetha prestador) {
    super();
    this.numeroProtocolo = numeroProtocolo;
    this.prestador = prestador;
  }

  public String getNumeroProtocolo() {
    return numeroProtocolo;
  }

  public RpsPrestadorBetha getPrestador() {
    return prestador;
  }
  
}
