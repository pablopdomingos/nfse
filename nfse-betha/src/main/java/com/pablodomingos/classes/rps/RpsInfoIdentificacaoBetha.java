package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsStatus;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RpsInfoIdentificacaoBetha extends AbstractRPS {

  @Element(name = "IdentificacaoRps", required = false)
  @NotNull
  @Valid
  private RpsIdentificacaoBetha identificacaoRps;

  @Element(name = "DataEmissao", required = false)
  @NotNull
  private LocalDate dataEmissao;

  @Element(name = "Status", required = false)
  @NotNull
  private RpsStatus status;

  public RpsInfoIdentificacaoBetha() {
  }

  public RpsInfoIdentificacaoBetha(RpsIdentificacaoBetha identificacaoRps, LocalDate dataEmissao, RpsStatus status) {
    this.identificacaoRps = identificacaoRps;
    this.dataEmissao = dataEmissao;
    this.status = status;
  }

  public RpsIdentificacaoBetha getIdentificacaoRps() {
    return identificacaoRps;
  }

  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  public RpsStatus getStatus() {
    return status;
  }
}
