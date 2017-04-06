package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import com.pablodomingos.validators.ValidaCodigoCancelamento;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSeInfPedidoCancelamento extends AbstractRPS {

    @Attribute(name="Id")
    @NotNull
    private String id;

    @Element(name="IdentificacaoNfse")
    @NotNull
    private NFSeIdentificacao nfseIdentificacao;

    @Element(name = "CodigoCancelamento")
    @NotNull
    @ValidaCodigoCancelamento.Validate
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
