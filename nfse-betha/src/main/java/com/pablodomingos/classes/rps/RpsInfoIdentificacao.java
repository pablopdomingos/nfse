package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsStatus;
import com.pablodomingos.conversores.LocalDateConversor;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RpsInfoIdentificacao extends AbstractRPS {

  @Element(name="IdentificacaoRps")
  @NotNull
  @Valid
  private RpsIdentificacao identificacaoRps;

  @Element(name="DataEmissao")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate dataEmissao;

  @Element(name="Status")
  @NotNull
  private RpsStatus status;

  public RpsInfoIdentificacao(RpsIdentificacao identificacaoRps, LocalDate dataEmissao, RpsStatus status) {
    this.identificacaoRps = identificacaoRps;
    this.dataEmissao = dataEmissao;
    this.status = status;
  }

  public RpsIdentificacao getIdentificacaoRps() {
    return identificacaoRps;
  }

  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  public RpsStatus getStatus() {
    return status;
  }
}
