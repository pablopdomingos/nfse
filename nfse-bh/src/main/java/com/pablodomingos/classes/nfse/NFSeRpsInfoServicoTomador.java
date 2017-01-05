package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServicoTomador {

  @XStreamAlias("IdentificacaoTomador")
  private NFSeRpsInfoServicoTomadorIdentificacao identificacaoTomador;
  
  @XStreamAlias("RazaoSocial")
  private String razaoSocial;
  
  @XStreamAlias("Endereco")
  private NFSeRpsInfoServicoTomadorEndereco endereco;
  
  @XStreamAlias("Contato")
  private NFSeRpsInfoServicoTomadorContato contato;

  public NFSeRpsInfoServicoTomador() {
    identificacaoTomador = new NFSeRpsInfoServicoTomadorIdentificacao();
    endereco = new NFSeRpsInfoServicoTomadorEndereco();
    contato = new NFSeRpsInfoServicoTomadorContato();
  }

  public NFSeRpsInfoServicoTomadorEndereco getEndereco() {
    return endereco;
  }

  public void setEndereco(NFSeRpsInfoServicoTomadorEndereco endereco) {
    this.endereco = endereco;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = StringUtil.removeAcentos(razaoSocial);
  }

  public NFSeRpsInfoServicoTomadorIdentificacao getIdentificacaoTomador() {
    return identificacaoTomador;
  }

  public void setIdentificacaoTomador(NFSeRpsInfoServicoTomadorIdentificacao identificacaoTomador) {
    this.identificacaoTomador = identificacaoTomador;
  }

  public NFSeRpsInfoServicoTomadorContato getContato() {
    return contato;
  }

  public void setContato(NFSeRpsInfoServicoTomadorContato contato) {
    this.contato = contato;
  }

}
