package com.pablodomingos.classes.nfse.builders;

import com.pablodomingos.classes.nfse.NFSeTomador;
import com.pablodomingos.classes.nfse.NFSeTomadorEndereco;
import com.pablodomingos.validadores.ValidadorString;

public class TomadorBuilder{

  private String nome;
  private String documento;
  private String inscricaoMunicipal;
  private String telefone;
  private String email;
  private NFSeTomadorEndereco endereco;
  
  public TomadorBuilder(String documento) {
    if (documento == null) {
      throw new IllegalArgumentException("Documento não pode ser nulo");
    }
    this.documento = documento;
  }

  public TomadorBuilder comNome(String nome) {
    this.nome = ValidadorString.comTamanhoMaximoEMinimo(115, 1, nome, "Nome");
    return this;
  }

  public TomadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal");
    return this;
  }

  public TomadorBuilder comTelefone(String telefone) {
    this.telefone = ValidadorString.comTamanhoMaximoEMinimo(15, 1, telefone, "Telefone");
    return this;
  }

  public TomadorBuilder comEmail(String email) {
    this.email = ValidadorString.comTamanhoMaximoEMinimo(80, 1, email, "Email");
    return this;
  }
  
  public TomadorBuilder comEndereco(NFSeTomadorEndereco endereco){
    this.endereco = endereco;
    return this;
  }
  
  public TomadorBuilder comEndereco(TomadorEnderecoBuilder endereco){
    this.endereco = new NFSeTomadorEndereco(endereco);
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

  public NFSeTomadorEndereco getEndereco() {
    return endereco;
  }
  
}

