package com.pablodomingos.classes.rps;

import java.time.DateTimeException;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.pablodomingos.conversores.LocalDateConversor;
import org.simpleframework.xml.Element;
import com.thoughtworks.xstream.annotations.XStreamConverter;


public class PeriodoEmissao extends AbstractRPS {
  @Element(name="DataInicial")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate dataInicial;

  @Element(name="DataFinal")
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
