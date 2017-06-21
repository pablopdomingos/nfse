package com.pablodomingos.classes.rps;


import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RpsTomadorBH extends AbstractRPS {

  @Element(name="IdentificacaoTomador")
  private RpsTomadorIdentificacaoBH identificacaoTomador;

  @Element(name="RazaoSocial")
  @Size(min = 1, max = 115)
  private String nome;

  @Element(name="Endereco")
  @NotNull
  private RpsTomadorEnderecoBH endereco;

  @Element(name="Contato")
  private RpsTomadorContatoBH contato;

  public RpsTomadorBH(TomadorBuilder builder) {
    this.contato = new RpsTomadorContatoBH(builder.getTelefone(), builder.getEmail());
    this.identificacaoTomador = new RpsTomadorIdentificacaoBH(
          new RpsTomadorCpfCnpjBH(builder.getCpf(), builder.getCnpj()),
          builder.getInscricaoMunicipal()
    );
    this.endereco = new RpsTomadorEnderecoBH(
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

  public RpsTomadorEnderecoBH getEndereco() {
    return endereco;
  }

  public String getNome() {
    return nome;
  }

  public RpsTomadorIdentificacaoBH getIdentificacaoTomador() {
    return identificacaoTomador;
  }

  public RpsTomadorContatoBH getContato() {
    return contato;
  }

}
