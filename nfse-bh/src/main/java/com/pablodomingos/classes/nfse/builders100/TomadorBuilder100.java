package com.pablodomingos.classes.nfse.builders100;

import com.pablodomingos.classes.nfse.NFSeTomador;
import com.pablodomingos.classes.nfse.builders.interfaces.TomadorBuilder;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.pablodomingos.validadores.ValidadorString;

public class TomadorBuilder100 implements TomadorBuilder {

  private String nome;
  private String documento;
  private String inscricaoMunicipal;
  private String telefone;
  private String email;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String codigoMunicipio;
  private String uf;
  private String cep;

  public TomadorBuilder100(String documento) {
    if (documento == null) {
      throw new IllegalArgumentException("Documento não pode ser nulo");
    }
    this.documento = documento;
  }

  public TomadorBuilder100 comNome(String nome) {
    this.nome = ValidadorString.comTamanhoMaximoEMinimo(115, 1, nome, "Nome");
    return this;
  }

  public TomadorBuilder100 comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal");
    return this;
  }

  public TomadorBuilder100 comTelefone(String telefone) {
    this.telefone = ValidadorString.comTamanhoMaximoEMinimo(15, 1, telefone, "Telefone");
    return this;
  }

  public TomadorBuilder100 comEmail(String email) {
    this.email = ValidadorString.comTamanhoMaximoEMinimo(80, 1, email, "Email");
    return this;
  }

  public TomadorBuilder100 comLogradouro(String logradouro) {
    this.logradouro = ValidadorString.comTamanhoMaximoEMinimo(125, 1, logradouro, "Logradouro");
    return this;
  }

  public TomadorBuilder100 comNumeroEndereco(String numero) {
    this.numero = ValidadorString.comTamanhoMaximoEMinimo(10, 1, numero, "Numero do endereco");
    return this;
  }

  public TomadorBuilder100 comComplemento(String complemento) {
    this.complemento = ValidadorString.comTamanhoMaximoEMinimo(60, 1, complemento, "Complemento do endereco");
    return this;
  }

  public TomadorBuilder100 comBairro(String bairro) {
    this.bairro = ValidadorString.comTamanhoMaximoEMinimo(60, 1, bairro, "Bairro");
    return this;
  }

  public TomadorBuilder100 comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = ValidadorString.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio");
    return this;
  }

  public TomadorBuilder100 comCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = ValidadorInteiro.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio").toString();
    return this;
  }
  
  public TomadorBuilder100 comUf(String uf) {
    this.uf = ValidadorString.comTamanhoExato(2, uf, "Uf");
    return this;
  }
  
  public TomadorBuilder100 comCep(String cep) {
    this.cep = ValidadorString.comTamanhoExato(8, cep, "Cep");
    return this;
  }

  public NFSeTomador build() {
    return new NFSeTomador(this);
  }

  public String getNome() {
    return nome;
  }

  public String getDocumento() {
    return documento;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getEmail() {
    return email;
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

