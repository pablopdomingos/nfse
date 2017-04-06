package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import com.pablodomingos.validators.ValidaCodigoCancelamentoBH;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;

public class NFSeInfPedidoCancelamentoBH extends AbstractRPS {

    @Attribute(name="Id")
    @NotNull
    private String id;

    @Element(name="IdentificacaoNfse")
    @NotNull
    private NFSeIdentificacaoBH nfseIdentificacao;

    @Element(name = "CodigoCancelamento")
    @NotNull
    @ValidaCodigoCancelamentoBH.Validate
    private CodigoCancelamento codigoCancelamento;

    public NFSeInfPedidoCancelamentoBH(PedidoCancelamentoInfBuilder builder) {
        this.id = builder.getId();
        this.nfseIdentificacao = new NFSeIdentificacaoBH(
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

    public NFSeIdentificacaoBH getNfseIdentificacao() {
    return nfseIdentificacao;
    }

    public CodigoCancelamento getCodigoCancelamento() {
    return codigoCancelamento;
  }
}
