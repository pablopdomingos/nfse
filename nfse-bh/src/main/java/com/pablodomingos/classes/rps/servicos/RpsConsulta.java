package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.RpsIdentificacao;
import com.pablodomingos.classes.rps.RpsPrestador;
<<<<<<< HEAD
import com.thoughtworks.xstream.XStream;
=======
>>>>>>> 043835f05c7e265fd3b9ea061abbef840b63aa14
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseRpsEnvio")
public class RpsConsulta extends AbstractService{

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("IdentificacaoRps")
  @NotNull
  private RpsIdentificacao identificacaoRps;

  @XStreamAlias("Prestador")
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
