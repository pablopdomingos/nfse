package com.pablodomingos.classes.rps;

import java.time.DateTimeException;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.pablodomingos.conversores.LocalDateConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


public class PeriodoEmissao extends AbstractRPS {
  @XStreamAlias("DataInicial")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate dataInicial;

  @XStreamAlias("DataFinal")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate dataFinal;

  public PeriodoEmissao(LocalDate dataInicial, LocalDate dataFinal) {
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
