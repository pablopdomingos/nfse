package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSeInfPedidoCancelamentoBetha extends AbstractRPS {

    @Attribute(name="Id")
    @NotNull
    private String id;

    @Element(name="IdentificacaoNfse")
    @NotNull
    private NFSeIdentificacaoBetha nfseIdentificacao;

    @Element(name="CodigoCancelamento")
    @NotNull
    private CodigoCancelamento codigoCancelamento;

    public NFSeInfPedidoCancelamentoBetha(PedidoCancelamentoInfBuilder builder) {
        this.id = builder.getId();
        this.nfseIdentificacao = new NFSeIdentificacaoBetha(
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

    public NFSeIdentificacaoBetha getNfseIdentificacao() {
    return nfseIdentificacao;
    }

    public CodigoCancelamento getCodigoCancelamento() {
    return codigoCancelamento;
  }
}
