package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class NFSeInfPedidoCancelamento {

  @XStreamAlias("Id")
  @NotNull
  @XStreamAsAttribute
  private String id;
  
  @XStreamAlias("IdentificacaoNfse")
  @NotNull
  private NFSeIdentificacao nfseIdentificacao;
  
  @XStreamAlias("CodigoCancelamento")
  @NotNull
  private CodigoCancelamento codigoCancelamento;
  
  public NFSeInfPedidoCancelamento(PedidoCancelamentoInfBuilder builder) {
    this.id = builder.getId();
    this.nfseIdentificacao = builder.getNfseIdentificacao();
    this.codigoCancelamento = builder.getCodigoCancelamento();
  }

  public String getId() {
    return id;
  }

  public NFSeIdentificacao getNfseIdentificacao() {
    return nfseIdentificacao;
  }

  public CodigoCancelamento getCodigoCancelamento() {
    return codigoCancelamento;
  }
  
}
