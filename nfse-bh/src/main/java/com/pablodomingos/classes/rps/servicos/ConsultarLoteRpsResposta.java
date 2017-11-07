package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.webservices.pbh.Nfse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarLoteRpsResposta")
public class ConsultarLoteRpsResposta {
  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("ListaMensagemRetornoLote")
  private ListaMensagemRetorno listaMensagemRetornoLote;

  @XStreamAlias("ListaMensagemRetorno")
  private ListaMensagemRetorno listaMensagemRetorno;

  @XStreamAlias("ListaNfse")
  private ListaNfse listaNfse;

  public static ConsultarLoteRpsResposta toPojo(String xml) {
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    xstream.ignoreUnknownElements();
    xstream.alias("ConsultarLoteRpsResposta", ConsultarLoteRpsResposta.class);
    xstream.alias("Nfse", Nfse.class);
    ConsultarLoteRpsResposta gerarNfseResposta = (ConsultarLoteRpsResposta) xstream.fromXML(xml);
    return gerarNfseResposta;
  }

  public ListaMensagemRetorno getListaMensagemRetornoLote() {
    return listaMensagemRetornoLote;
  }

  public void setListaMensagemRetornoLote(ListaMensagemRetorno listaMensagemRetornoLote) {
    this.listaMensagemRetornoLote = listaMensagemRetornoLote;
  }

  public ListaNfse getListaNfse() {
    return listaNfse;
  }

  public void setListaNfse(ListaNfse listaNfse) {
    this.listaNfse = listaNfse;
  }

}
