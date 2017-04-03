package com.pablodomingos.classes.rps;


import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsTomador extends AbstractRPS {

  @XStreamAlias("IdentificacaoTomador")
  private RpsTomadorIdentificacao identificacaoTomador;

  @XStreamAlias("RazaoSocial")
  @Size(min = 1, max = 115)
  private String nome;

  @XStreamAlias("Endereco")
  @NotNull
  private RpsTomadorEndereco endereco;

  @XStreamAlias("Contato")
  private RpsTomadorContato contato;

  public RpsTomador(TomadorBuilder builder) {
    this.contato = new RpsTomadorContato(builder.getTelefone(), builder.getEmail());
    this.identificacaoTomador = new RpsTomadorIdentificacao(
          new RpsTomadorCpfCnpj(builder.getCpf(), builder.getCnpj()),
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
