package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.RpsPrestador;
<<<<<<< HEAD
import com.thoughtworks.xstream.XStream;
=======
>>>>>>> 043835f05c7e265fd3b9ea061abbef840b63aa14
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarSituacaoLoteRpsEnvio")
public class LoteRpsConsultaSituacao extends AbstractService{

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
  
  public LoteRpsConsultaSituacao(String numeroProtocolo, RpsPrestador prestador) {
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
