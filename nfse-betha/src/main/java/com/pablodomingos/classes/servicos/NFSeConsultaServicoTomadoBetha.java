package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

@Root(name = "ConsultarNfseServicoTomadoEnvio")
public class NFSeConsultaServicoTomadoBetha extends NFSeConsultaBetha {

  @Element(name = "Consulente", required = false)
  RpsPrestadorBetha consulente;

  public NFSeConsultaServicoTomadoBetha(RpsPrestadorBetha prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super(prestador, dataInicial, dataFinal);
  }

  public RpsPrestadorBetha getConsulente() {
    return consulente;
  }

  public void setConsulente(RpsPrestadorBetha consulente) {
    this.consulente = consulente;
  }
}
