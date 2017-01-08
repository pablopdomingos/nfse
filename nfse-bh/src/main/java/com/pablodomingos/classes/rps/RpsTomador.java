package com.pablodomingos.classes.rps;


import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RpsTomador {

  @XStreamAlias("IdentificacaoTomador")
  private RpsTomadorIdentificacao identificacaoTomador;
  
  @XStreamAlias("RazaoSocial")
  private String nome;
  
  @XStreamAlias("Endereco")
  private RpsTomadorEndereco endereco;
  
  @XStreamAlias("Contato")
  private RpsTomadorContato contato;

  public RpsTomador(TomadorBuilder builder) {
    
    this.contato = builder.getContato();
    this.identificacaoTomador = new RpsTomadorIdentificacao()
        .comCpfCnpj(new RpsTomadorCpfCnpj(builder.getDocumento()))
        .comInscricaoMunicipal(builder.getInscricaoMunicipal());
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
