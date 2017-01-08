package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsValores;
import com.pablodomingos.conversores.StringUtil;
import com.pablodomingos.validadores.ValidadorInteiro;
import com.pablodomingos.validadores.ValidadorString;

public class ServicoBuilder {

  private RpsValores valores;
  private String codigoItemListaServico;
  private String codigoCnae;
  private String codigoTributacaoMunicipio;
  private String discriminacao;
  private String codigoMunicipio;

  public ServicoBuilder(RpsValores valores, String codigoItemListaServico) {
    if (codigoItemListaServico == null || valores == null) {
      throw new IllegalArgumentException("Os valores e o codigo de servico não podem ser nulos");
    }
    this.valores = valores;
    this.codigoItemListaServico = ValidadorString.comTamanhoMaximoEMinimo(5, 1, codigoItemListaServico, "Codigo de item da lista de servico");
  }

  public ServicoBuilder comCodigoCnae(Integer codigoCnae) {
    this.codigoCnae = Integer.toString(ValidadorInteiro.comTamanhoMaximo(7, codigoCnae, "Cnae do servico"));
    return this;
  }
  
  public ServicoBuilder comCodigoCnae(String codigoCnae) {
    this.codigoCnae = ValidadorString.comTamanhoMaximo(7, codigoCnae, "Cnae do servico");
    return this;
  }
  
  public ServicoBuilder comDiscriminacao(String discriminacao) {
    this.discriminacao = ValidadorString.comTamanhoMaximoEMinimo(2000, 1, StringUtil.removeAcentos(discriminacao), "Descricao do servico");
    return this;
  }
  
  public ServicoBuilder comCodigoMunicipio(Integer codigoMunicipio) {
    this.codigoMunicipio = Integer.toString(ValidadorInteiro.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio"));
    return this;
  }
  
  public ServicoBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = ValidadorString.comTamanhoMaximo(7, codigoMunicipio, "Codigo do municipio");
    return this;
  }
  
  public ServicoBuilder comCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
    this.codigoTributacaoMunicipio = ValidadorString.comTamanhoMaximoEMinimo(20, 1, codigoTributacaoMunicipio, "Codigo tributacao do municipio");
    return this;
  }
  
  public RpsServico build() {
    return new RpsServico(this);
  }

  public RpsValores getValores() {
    return valores;
  }

  public String getCodigoItemListaServico() {
    return codigoItemListaServico;
  }

  public String getCodigoCnae() {
    return codigoCnae;
  }

  public String getCodigoTributacaoMunicipio() {
    return codigoTributacaoMunicipio;
  }

  public String getDiscriminacao() {
    return discriminacao;
  }

  public String getCodigoMunicipio() {
    return codigoMunicipio;
  }

}

