package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

@Root(name = "ConsultarNfseServicoPrestadoEnvio")
public class NFSeConsultaServicoPrestadoBetha extends NFSeConsultaBetha {
  public NFSeConsultaServicoPrestadoBetha(RpsPrestadorBetha prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super(prestador, dataInicial, dataFinal);
  }
}
