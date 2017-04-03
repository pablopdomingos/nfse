package com.pablodomingos.classes.rps.builders;

public class TomadorBuilder extends AbstractBuilder {

  private String inscricaoMunicipal;
  private String nome;
  private String telefone;
  private String email;
  private String cpf;
  private String cnpj;
  private String documento;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String codigoMunicipio;
  private String uf;
  private String cep;

  public TomadorBuilder(String documento) {
    this.comDocumento(documento);
  }

  public TomadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  public TomadorBuilder comNome(String nome) {
    this.nome = nome;
    return this;
  }

  public TomadorBuilder comTelefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  public TomadorBuilder comEmail(String email) {
    this.email = email;
    return this;
  }

  public TomadorBuilder comDocumento(String documento) {
    this.documento = documento;
    if(documento.length() == 11){
      this.cpf = documento;
    }else{
      this.cnpj = documento;
    }
    return this;
  }

  public TomadorBuilder comLogradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

  public TomadorBuilder comNumeroEndereco(String numero) {
    this.numero = numero;
    return this;
  }

  public TomadorBuilder comComplemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

  public TomadorBuilder comBairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  public TomadorBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
    return this;
  }

  public TomadorBuilder comUf(String uf) {
    this.uf = uf;
    return this;
  }

  public TomadorBuilder comCep(String cep) {
    this.cep = cep;
    return this;
  }

  public String getCpf() {
    return cpf;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getEmail() {
    return email;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public String getNome() {
    return nome;
  }

  public String getDocumento() {
    return documento;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public String getUf() {
    return uf;
  }

  public String getCep() {
    return cep;
  }
}

