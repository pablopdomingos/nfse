package com.pablodomingos.classes.nfse;

import com.pablodomingos.classes.nfse.builders.interfaces.TomadorBuilder;
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
    this.endereco = new NFSeTomadorEndereco()
        .comEndereco(builder.getLogradouro())
        .comNumero(builder.getNumero())
        .comBairro(builder.getBairro())
        .comComplemento(builder.getComplemento())
        .comCep(builder.getCep())
        .comUf(builder.getUf())
        .comCodigoMunicipio(builder.getCodigoMunicipio());
    this.contato = new NFSeTomadorContato()
        .comEmail(builder.getEmail())
        .comTelefone(builder.getTelefone());
    this.identificacaoTomador = new NFSeTomadorIdentificacao()
        .comCpfCnpj(new NFSeTomadorCpfCnpj().comDocumento(builder.getDocumento()))
        .comInscricaoMunicipal(builder.getInscricaoMunicipal());
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
