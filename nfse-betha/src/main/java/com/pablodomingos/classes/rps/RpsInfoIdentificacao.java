package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsStatus;
import com.pablodomingos.conversores.LocalDateConversor;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RpsInfoIdentificacao extends AbstractRPS {

  @XStreamAlias("IdentificacaoRps")
  @NotNull
  @Valid
  private RpsIdentificacao identificacaoRps;

  @XStreamAlias("DataEmissao")
  @XStreamConverter(LocalDateConversor.class)
  @NotNull
  private LocalDate dataEmissao;

  @XStreamAlias("Status")
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
