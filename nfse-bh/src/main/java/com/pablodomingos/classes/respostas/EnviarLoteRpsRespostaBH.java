package com.pablodomingos.classes.respostas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;

@Root(name = "EnviarLoteRpsResposta")
public class EnviarLoteRpsRespostaBH extends RespostaAbstract {
  @Element(name = "NumeroLote")
  private Integer numeroLote;
  @Element(name = "DataRecebimento")
  private LocalDateTime dataRecebimento;
  @Element(name = "Protocolo")
  private String protocolo;

  public Integer getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(Integer numeroLote) {
    this.numeroLote = numeroLote;
  }

  public LocalDateTime getDataRecebimento() {
    return dataRecebimento;
  }

  public void setDataRecebimento(LocalDateTime dataRecebimento) {
    this.dataRecebimento = dataRecebimento;
  }

  public String getProtocolo() {
    return protocolo;
  }

  public void setProtocolo(String protocolo) {
    this.protocolo = protocolo;
  }
}
