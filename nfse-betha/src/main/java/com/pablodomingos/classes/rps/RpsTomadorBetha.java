package com.pablodomingos.classes.rps;


import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsTomadorBetha extends AbstractRPS {

    @Element(name = "IdentificacaoTomador")
    private RpsTomadorIdentificacaoBetha identificacaoTomador;

    @Element(name = "RazaoSocial")
    @Size(min = 1, max = 115)
    private String nome;

    @Element(name = "Endereco")
    @NotNull
    private RpsTomadorEnderecoBetha endereco;

    @Element(name = "Contato")
    private RpsTomadorContatoBetha contato;

    public RpsTomadorBetha(TomadorBuilder builder) {
        this.contato = new RpsTomadorContatoBetha(builder.getTelefone(), builder.getEmail());
        this.identificacaoTomador = new RpsTomadorIdentificacaoBetha(
                new RpsCpfCnpjBetha(builder.getCpf(), builder.getCnpj()),
                builder.getInscricaoMunicipal()
        );
        this.endereco = new RpsTomadorEnderecoBetha(
                builder.getLogradouro(),
                builder.getNumero(),
                builder.getComplemento(),
                builder.getBairro(),
                builder.getCodigoMunicipio(),
                builder.getUf(),
                builder.getCep()
        );
        this.nome = builder.getNome();
    }

    public RpsTomadorEnderecoBetha getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public RpsTomadorIdentificacaoBetha getIdentificacaoTomador() {
        return identificacaoTomador;
    }

    public RpsTomadorContatoBetha getContato() {
        return contato;
    }

}
