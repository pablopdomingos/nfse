package com.pablodomingos.classes.rps;

import javax.validation.constraints.NotNull;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class NFSeInfPedidoCancelamento extends AbstractRPS {

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
        this.nfseIdentificacao = new NFSeIdentificacao(
            builder.getNumero(),
            builder.getCnpj(),
            builder.getInscricaoMunicipal(),
            builder.getCodigoMunicipioIbge()
        );
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
