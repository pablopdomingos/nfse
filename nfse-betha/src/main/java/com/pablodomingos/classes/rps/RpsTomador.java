package com.pablodomingos.classes.rps;


import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsTomador extends AbstractRPS {

    @Element(name = "IdentificacaoTomador")
    private RpsTomadorIdentificacao identificacaoTomador;

    @Element(name = "RazaoSocial")
    @Size(min = 1, max = 115)
    private String nome;

    @Element(name = "Endereco")
    @NotNull
    private RpsTomadorEndereco endereco;

    @Element(name = "Contato")
    private RpsTomadorContato contato;

    public RpsTomador(TomadorBuilder builder) {
        this.contato = new RpsTomadorContato(builder.getTelefone(), builder.getEmail());
        this.identificacaoTomador = new RpsTomadorIdentificacao(
                new RpsCpfCnpj(builder.getCpf(), builder.getCnpj()),
                builder.getInscricaoMunicipal()
        );
        this.endereco = new RpsTomadorEndereco(
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

    public RpsTomadorEndereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public RpsTomadorIdentificacao getIdentificacaoTomador() {
        return identificacaoTomador;
    }

    public RpsTomadorContato getContato() {
        return contato;
    }

}
