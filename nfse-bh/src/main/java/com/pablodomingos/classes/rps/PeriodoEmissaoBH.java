package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import java.time.DateTimeException;
import java.time.LocalDate;


public class PeriodoEmissaoBH extends AbstractRPS {
  @Element(name = "DataInicial")
  @NotNull
  private LocalDate dataInicial;

  @Element(name = "DataFinal")
  @NotNull
  private LocalDate dataFinal;

  public PeriodoEmissaoBH(LocalDate dataInicial, LocalDate dataFinal) {
    this.dataInicial = dataInicial;
    if (dataFinal.isAfter(LocalDate.now())) {
      throw new DateTimeException("Data final nao pode ser maior que a atual");
    }
    this.dataFinal = dataFinal;
  }

  public LocalDate getDataInicial() {
    return dataInicial;
  }

  public LocalDate getDataFinal() {
    return dataFinal;
  }
}
