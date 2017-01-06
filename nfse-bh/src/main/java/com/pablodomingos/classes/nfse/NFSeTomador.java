package com.pablodomingos.classes.nfse;


import com.pablodomingos.classes.nfse.builders.TomadorBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeTomador {

  @XStreamAlias("IdentificacaoTomador")
  private NFSeTomadorIdentificacao identificacaoTomador;
  
  @XStreamAlias("RazaoSocial")
  private String nome;
  
  @XStreamAlias("Endereco")
  private NFSeTomadorEndereco endereco;
  
  @XStreamAlias("Contato")
  private NFSeTomadorContato contato;

  public NFSeTomador(TomadorBuilder builder) {
    
    this.nome = builder.getNome();
    this.contato = new NFSeTomadorContato()
        .comEmail(builder.getEmail())
        .comTelefone(builder.getTelefone());
    this.identificacaoTomador = new NFSeTomadorIdentificacao()
        .comCpfCnpj(new NFSeTomadorCpfCnpj().comDocumento(builder.getDocumento()))
        .comInscricaoMunicipal(builder.getInscricaoMunicipal());
    this.endereco = builder.getEndereco();
  }

  public NFSeTomadorEndereco getEndereco() {
    return endereco;
  }

  public String getNome() {
    return nome;
  }

  public NFSeTomadorIdentificacao getIdentificacaoTomador() {
    return identificacaoTomador;
  }

  public NFSeTomadorContato getContato() {
    return contato;
  }

}
