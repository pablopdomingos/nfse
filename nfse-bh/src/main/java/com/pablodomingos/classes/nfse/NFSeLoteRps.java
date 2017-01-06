package com.pablodomingos.classes.nfse;

import java.util.Collections;
import java.util.List;

import com.pablodomingos.classes.nfse.builders.LoteRpsBuilder;
import com.pablodomingos.classes.nfse.enums.LoteRpsVersao;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class NFSeLoteRps {

  @XStreamAlias("Id")
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("versao")
  @XStreamAsAttribute
  private LoteRpsVersao versao;

  @XStreamAlias("NumeroLote")
  private String numeroLote;

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  @XStreamAlias("QuantidadeRps")
  private int quantidadeRps;

  @XStreamAlias("ListaRps")
  private final List<NFSeRps> listaRps;

  public NFSeLoteRps(LoteRpsBuilder builder) {
    this.id = builder.getId();
    this.versao = builder.getVersao();
    this.numeroLote = builder.getNumeroLote();
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
    this.quantidadeRps = builder.getQuantidadeRps();
    this.listaRps = builder.getListaRps();
  }

  public String getId() {
    return id;
  }

  public LoteRpsVersao getVersao() {
    return versao;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  public Integer getQuantidadeRps() {
    return quantidadeRps;
  }

  public List<NFSeRps> getRps() {
    return Collections.unmodifiableList(listaRps);
  }

  
}
