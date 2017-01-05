package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServico {

  @XStreamAlias("Valores")
  private NFSeRpsInfoServicoValores valores;

  @XStreamAlias("ItemListaServico")
  private String codigoItemListaServico;

  @XStreamAlias("CodigoCnae")
  private Integer codigoCnae;

  @XStreamAlias("CodigoTributacaoMunicipio")
  private String codigoTributacaoMunicipio;

  @XStreamAlias("Discriminacao")
  private String discriminacao;

  @XStreamAlias("CodigoMunicipio")
  private Integer codigoMunicipio;


  public NFSeRpsInfoServico() {}

  public NFSeRpsInfoServicoValores getValores() {
    return valores;
  }

  public NFSeRpsInfoServico comValores(NFSeRpsInfoServicoValores valores) {
    this.valores = valores;
    return this;
  }

  public String getCodigoItemListaServico() {
    return codigoItemListaServico;
  }

  public NFSeRpsInfoServico comCodigoItemListaServico(String codigoItemListaServico) {
    this.codigoItemListaServico = ValidadorString.comTamanhoMaximoEMinimo(5, 1, codigoItemListaServico, "Codigo de item da lista de servico");
    return this;
  }

  public Integer getCodigoCnae() {
    return codigoCnae;
  }

  public NFSeRpsInfoServico comCodigoCnae(Integer codigoCnae) {
    this.codigoCnae = ValidadorInteiro.comTamanhoMaximo(7, codigoCnae, "Cnae do servico");
    return this;
  }

  public String getDiscriminacao() {
    return discriminacao;
  }

  public NFSeRpsInfoServico comDiscriminacao(String discriminacao) {
    this.discriminacao = ValidadorString.comTamanhoMaximoEMinimo(2000, 1, StringUtil.removeAcentos(discriminacao), "Descricao do servico");
    return this;
  }

  public Integer getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public NFSeRpsInfoServico comCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = ValidadorInteiro.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio");
    return this;
  }

  public String getCodigoTributacaoMunicipio() {
    return codigoTributacaoMunicipio;
  }

  public NFSeRpsInfoServico comCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
    this.codigoTributacaoMunicipio = ValidadorString.comTamanhoMaximoEMinimo(20, 1, codigoTributacaoMunicipio, "Codigo tributacao do municipio");
    return this;
  }

}
