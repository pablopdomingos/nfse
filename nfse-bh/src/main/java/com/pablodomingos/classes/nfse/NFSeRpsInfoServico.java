package com.pablodomingos.classes.nfse;

import com.pablodomingos.conversores.StringUtil;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.pablodomingos.validadores.ValidadorString;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NFSeRpsInfoServico {

  @XStreamAlias("Valores")
  private NFSeRpsInfoServicoValores valores;

  @XStreamAlias("ItemListaServico")
  private String itemListaServico;

  @XStreamAlias("CodigoCnae")
  private Integer codigoCnae;

  @XStreamAlias("CodigoTributacaoMunicipio")
  private String codigoTributacaoMunicipio;

  @XStreamAlias("Discriminacao")
  private String discriminacao;

  @XStreamAlias("CodigoMunicipio")
  private Integer codigoMunicipio;


  public NFSeRpsInfoServico() {
    valores = new NFSeRpsInfoServicoValores();
    valores.setIssRetido(NFSeRpsInfoServicoValoresIssRetido.NAO);
  }

  public NFSeRpsInfoServicoValores getValores() {
    return valores;
  }

  public void setValores(NFSeRpsInfoServicoValores valores) {
    this.valores = valores;
  }

  public String getItemListaServico() {
    return itemListaServico;
  }

  public void setItemListaServico(String itemListaServico) {
    this.itemListaServico = ValidadorString.comTamanhoMaximoEMinimo(5, 1, itemListaServico, "Item da lista de servico");
  }

  public Integer getCodigoCnae() {
    return codigoCnae;
  }

  public void setCodigoCnae(Integer codigoCnae) {
    this.codigoCnae = ValidadorInteiro.comTamanhoMaximo(7, codigoCnae, "Cnae do servico");
  }

  public String getDiscriminacao() {
    return discriminacao;
  }

  public void setDiscriminacao(String discriminacao) {
    this.discriminacao = ValidadorString.comTamanhoMaximoEMinimo(2000, 1, StringUtil.removeAcentos(discriminacao), "Descricao do servico");
  }

  public Integer getCodigoMunicipio() {
    return codigoMunicipio;
  }

  public void setCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = ValidadorInteiro.comTamanhoMaximo(7, codigoMunicipio, "Código do municipio");
  }

  public String getCodigoTributacaoMunicipio() {
    return codigoTributacaoMunicipio;
  }

  public void setCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
    this.codigoTributacaoMunicipio = ValidadorString.comTamanhoMaximoEMinimo(20, 1, codigoTributacaoMunicipio, "Codigo tributacao do municipio");
  }

}
