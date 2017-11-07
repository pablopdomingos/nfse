package com.pablodomingos.classes.rps.servicos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrestadorServico {

  @XStreamAlias("IdentificacaoPrestador")
  private IdentificacaoPrestadorServico identificacao;

  @XStreamAlias("RazaoSocial")
  private String razaoSocial;

  @XStreamAlias("Endereco")
  private EnderecoPrestadorServico endereco;

  @XStreamAlias("Contato")
  private ContatoPrestadorServico contato;

  public static class IdentificacaoPrestadorServico {
    @XStreamAlias("Cpf")
    private String cpf;

    @XStreamAlias("Cnpj")
    private String cnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;

    public String getCpf() {
      return cpf;
    }

    public void setCpf(String cpf) {
      this.cpf = cpf;
    }

    public String getCnpj() {
      return cnpj;
    }

    public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
      return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
      this.inscricaoMunicipal = inscricaoMunicipal;
    }
  }

  public class EnderecoPrestadorServico {
    @XStreamAlias("Endereco")
    private String endereco;

    @XStreamAlias("Numero")
    private String numero;

    @XStreamAlias("Complemento")
    private String complemento;

    @XStreamAlias("Bairro")
    private String bairro;

    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    @XStreamAlias("Uf")
    private String uf;

    @XStreamAlias("Cep")
    private String cep;

    public String getEndereco() {
      return endereco;
    }

    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }

    public String getNumero() {
      return numero;
    }

    public void setNumero(String numero) {
      this.numero = numero;
    }

    public String getComplemento() {
      return complemento;
    }

    public void setComplemento(String complemento) {
      this.complemento = complemento;
    }

    public String getBairro() {
      return bairro;
    }

    public void setBairro(String bairro) {
      this.bairro = bairro;
    }

    public String getCodigoMunicipio() {
      return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
      this.codigoMunicipio = codigoMunicipio;
    }

    public String getUf() {
      return uf;
    }

    public void setUf(String uf) {
      this.uf = uf;
    }

    public String getCep() {
      return cep;
    }

    public String getCepFormatado() {
      if (cep != null) {
        return cep.substring(0, cep.length() - 3) + "-"
            + cep.substring(cep.length() - 3, cep.length());
      }

      return cep;
    }

    public void setCep(String cep) {
      this.cep = cep;
    }

  }

  public static class ContatoPrestadorServico {
    @XStreamAlias("Telefone")
    private String telefone;

    @XStreamAlias("Email")
    private String email;

    public String getTelefone() {
      return telefone;
    }

    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

  }

  public IdentificacaoPrestadorServico getIdentificacao() {
    return identificacao;
  }

  public void setIdentificacao(IdentificacaoPrestadorServico identificacao) {
    this.identificacao = identificacao;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public EnderecoPrestadorServico getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoPrestadorServico endereco) {
    this.endereco = endereco;
  }

  public ContatoPrestadorServico getContato() {
    return contato;
  }

  public void setContato(ContatoPrestadorServico contato) {
    this.contato = contato;
  }

}
