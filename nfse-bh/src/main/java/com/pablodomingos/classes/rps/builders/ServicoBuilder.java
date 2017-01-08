package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsValores;

public class ServicoBuilder extends AbstractBuilder<RpsServico>{

  private RpsValores valores;
  private String codigoItemListaServico;
  private String codigoCnae;
  private String codigoTributacaoMunicipio;
  private String discriminacao;
  private String codigoMunicipio;

  public ServicoBuilder(RpsValores valores, String codigoItemListaServico) {
    this.valores = valores;
    this.codigoItemListaServico = codigoItemListaServico;
  }

  public ServicoBuilder comCodigoCnae(Integer codigoCnae) {
    return comCodigoCnae(Integer.toString(codigoCnae));
  }
  
  public ServicoBuilder comCodigoCnae(String codigoCnae) {
    this.codigoCnae = codigoCnae;
    return this;
  }
  
  public ServicoBuilder comDiscriminacao(String discriminacao) {
    this.discriminacao = discriminacao;
    return this;
  }
  
  public ServicoBuilder comCodigoMunicipio(Integer codigoMunicipio) {
    return comCodigoMunicipio(Integer.toString(codigoMunicipio));
  }
  
  public ServicoBuilder comCodigoMunicipio(String codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
    return this;
  }
  
  public ServicoBuilder comCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
    this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
    return this;
  }
  
  @Override
  protected RpsServico buildInternal() {
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

