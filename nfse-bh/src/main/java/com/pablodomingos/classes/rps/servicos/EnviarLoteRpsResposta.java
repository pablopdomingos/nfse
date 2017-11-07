package com.pablodomingos.classes.rps.servicos;


import java.time.LocalDateTime;
import com.pablodomingos.conversores.LocalDateTimeConversor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;


@XStreamAlias("EnviarLoteRpsResposta")
public class EnviarLoteRpsResposta {
  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("NumeroLote")
  private Long numeroLote;

  @XStreamAlias("DataRecebimento")
  @XStreamConverter(LocalDateTimeConversor.class)
  private LocalDateTime dataRecebimento;

  @XStreamAlias("Protocolo")
  private String protocolo;

  @XStreamAlias("ListaMensagemRetorno")
  private ListaMensagemRetorno listaMensagemRetorno;


  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public Long getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(Long numeroLote) {
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

  public ListaMensagemRetorno getListaMensagemRetorno() {
    return listaMensagemRetorno;
  }

  public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
    this.listaMensagemRetorno = listaMensagemRetorno;
  }

  public static EnviarLoteRpsResposta toPojo(String xml) {
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    xstream.ignoreUnknownElements();
    xstream.alias("EnviarLoteRpsResposta", EnviarLoteRpsResposta.class);
    EnviarLoteRpsResposta enviarLoteRpsResposta = (EnviarLoteRpsResposta) xstream.fromXML(xml);
    return enviarLoteRpsResposta;
  }
}
