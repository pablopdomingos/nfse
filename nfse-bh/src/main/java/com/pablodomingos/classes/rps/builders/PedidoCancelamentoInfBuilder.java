package com.pablodomingos.classes.rps.builders;

import java.util.UUID;

import com.pablodomingos.classes.rps.NFSeIdentificacao;
import com.pablodomingos.classes.rps.NFSeInfPedidoCancelamento;

public class PedidoCancelamentoInfBuilder extends AbstractBuilder<NFSeInfPedidoCancelamento>{

  private String id;
  private NFSeIdentificacao nfseIdentificacao;
  private String codigoCancelamento;
  
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
  
  public PedidoCancelamentoInfBuilder comCodigoCancelamento(String codigoCancelamento){
    this.codigoCancelamento = codigoCancelamento;
    return this;
  }
  
  @Override
  public NFSeInfPedidoCancelamento buildInternal() {
    return new NFSeInfPedidoCancelamento(this);
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
