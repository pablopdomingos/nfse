package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NFSeIdentificacaoBetha extends AbstractRPS {

    @Element(name = "Numero")
    @NotNull
    @Pattern(regexp = "\\d+")
    @Size(min = 1, max = 15)
    private String numero;

    @Element(name = "CpfCnpj")
    @NotNull
    private RpsCpfCnpjBetha cpfCnpj;

    @Element(name = "InscricaoMunicipal", required = false)
    @Size(min = 1, max = 15)
    private String inscricaoMunicipal;

    @Element(name = "CodigoMunicipio", required = false)
    @Pattern(regexp = "\\d+")
    @Size(min = 1, max = 7)
    private String codigoMunicipioIbge;

    public NFSeIdentificacaoBetha(String numero, String cnpj, String inscricaoMunicipal, String codigoMunicipioIbge) {
        this.numero = numero;
        this.cpfCnpj = new RpsCpfCnpjBetha(cnpj);
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.codigoMunicipioIbge = codigoMunicipioIbge;
    }

    public String getNumero() {
        return numero;
    }

    public RpsCpfCnpjBetha getCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getCodigoMunicipioIbge() {
        return codigoMunicipioIbge;
    }

}
