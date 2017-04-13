package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.rps.RpsPrestadorBetha;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

@Root(name = "ConsultarNfseServicoPrestadoEnvio")
public class NFSeConsultaServicoPrestadoBetha extends NFSeConsultaBetha {
  @Element(name="Pagina", required = false)
  private Integer pagina;

  public NFSeConsultaServicoPrestadoBetha(RpsPrestadorBetha prestador, LocalDate dataInicial, LocalDate dataFinal) {
    super(prestador, dataInicial, dataFinal);
  }

  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }
}
