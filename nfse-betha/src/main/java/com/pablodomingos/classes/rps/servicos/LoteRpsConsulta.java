package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.RpsPrestador;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarLoteRpsEnvio")
public class LoteRpsConsulta extends AbstractServiceBetha {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("Prestador")
  @NotNull
  private RpsPrestador prestador;

  @XStreamAlias("Protocolo")
  @NotNull
  @Size(max = 50)
  private String numeroProtocolo;
  
  public LoteRpsConsulta(String numeroProtocolo, RpsPrestador prestador) {
    super();
    this.numeroProtocolo = numeroProtocolo;
    this.prestador = prestador;
  }

  public String getNumeroProtocolo() {
    return numeroProtocolo;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }
  
}
