package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NfseInfPedidoCancelamentoBetha extends AbstractRPS {

    @Attribute(name="Id", required = false)
    @NotNull
    private String id;

    @Element(name="IdentificacaoNfse", required = false)
    @NotNull
    private NfseIdentificacaoBetha nfseIdentificacao;

    @Element(name="CodigoCancelamento", required = false)
    @NotNull
    private CodigoCancelamento codigoCancelamento;

    public NfseInfPedidoCancelamentoBetha() {
    }

    public NfseInfPedidoCancelamentoBetha(PedidoCancelamentoInfBuilder builder) {
        this.id = builder.getId();
        this.nfseIdentificacao = new NfseIdentificacaoBetha(
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

    public NfseIdentificacaoBetha getNfseIdentificacao() {
    return nfseIdentificacao;
    }

    public CodigoCancelamento getCodigoCancelamento() {
    return codigoCancelamento;
  }
}
