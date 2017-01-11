package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
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
  @Size(min=1, max=4)
  private String codigoCancelamento;
  
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

  public String getCodigoCancelamento() {
    return codigoCancelamento;
  }
  
}
