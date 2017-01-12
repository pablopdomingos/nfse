package com.pablodomingos.classes.rps;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import com.pablodomingos.classes.rps.builders.TomadorIdentificacaoBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomador {

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
    
    RpsTomadorIdentificacao tomadorIdentificacao = new TomadorIdentificacaoBuilder()
        .comCpfCnpj(builder.getTomadorCpfCnpj())
        .comInscricaoMunicipal(builder.getInscricaoMunicipal())
        .build();

    this.contato = builder.getContato();
    this.identificacaoTomador = tomadorIdentificacao;
    this.endereco = builder.getEndereco();
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
