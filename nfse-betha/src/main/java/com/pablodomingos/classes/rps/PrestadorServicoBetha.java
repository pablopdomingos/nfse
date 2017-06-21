package com.pablodomingos.classes.rps;

import org.simpleframework.xml.Element;

public class PrestadorServicoBetha {

  @Element(name="IdentificacaoPrestador", required = false)
  private  RpsPrestadorBetha identificacaoPrestador;


  @Element(name="RazaoSocial", required = false)
  private String razaoSocial;


  @Element(name="NomeFantasia", required = false)
  private String nomeFantasia;


  @Element(name="Endereco", required = false)
  private EnderecoBetha endereco;


  @Element(name="Contato", required = false)
  private ContatoBetha contato;

  public RpsPrestadorBetha getIdentificacaoPrestador() {
    return identificacaoPrestador;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public EnderecoBetha getEndereco() {
    return endereco;
  }

  public ContatoBetha getContato() {
    return contato;
  }
}

