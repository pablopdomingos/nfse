package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Root(name="ConsultarSituacaoLoteRpsEnvio")
public class LoteRpsConsultaSituacaoBetha extends AbstractServiceBetha {

  @Attribute(name="xmlns")
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @Element(name="Prestador")
  @NotNull
  private RpsPrestadorBetha prestador;

  @Element(name="Protocolo")
  @NotNull
  @Size(max = 50)
  private String numeroProtocolo;
  
  public LoteRpsConsultaSituacaoBetha(String numeroProtocolo, RpsPrestadorBetha prestador) {
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
