package com.pablodomingos.classes.rps.builders;

import java.util.UUID;

import com.pablodomingos.classes.rps.NFSeIdentificacao;
import com.pablodomingos.classes.rps.NFSeInfPedidoCancelamento;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;

public class PedidoCancelamentoInfBuilder extends AbstractBuilder<NFSeInfPedidoCancelamento>{

  private String id;
  private NFSeIdentificacao nfseIdentificacao;
  private CodigoCancelamento codigoCancelamento;
  
  public PedidoCancelamentoInfBuilder() {
    this.id = UUID.randomUUID().toString();
  }
  
  public PedidoCancelamentoInfBuilder comId(String id){
    this.id = id;
    return this;
  }
  
  public PedidoCancelamentoInfBuilder comNFSeIdentificacao(NFSeIdentificacao nfseIdentificacao){
    this.nfseIdentificacao = nfseIdentificacao;
    return this;
  }
  
  public PedidoCancelamentoInfBuilder comCodigoCancelamento(CodigoCancelamento codigoCancelamento){
    this.codigoCancelamento = codigoCancelamento;
    return this;
  }
  
  @Override
  protected NFSeInfPedidoCancelamento buildInternal() {
    return new NFSeInfPedidoCancelamento(this);
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
