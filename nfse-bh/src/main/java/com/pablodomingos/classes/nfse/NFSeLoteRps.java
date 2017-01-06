package com.pablodomingos.classes.nfse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.pablodomingos.classes.nfse.enums.LoteRpsVersao;
import com.pablodomingos.validadores.ValidadorInteiro;
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
  private BigInteger numeroLote;

  @XStreamAlias("Cnpj")
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  private String inscricaoMunicipal;

  @XStreamAlias("QuantidadeRps")
  private int quantidadeRps;

  @XStreamAlias("ListaRps")
  
  private final List<NFSeRps> listaRps;

  public NFSeLoteRps() {
    id = UUID.randomUUID().toString();
    listaRps = new ArrayList<NFSeRps>();
    versao = LoteRpsVersao.V1_00;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public LoteRpsVersao getVersao() {
    return versao;
  }

  public void setVersao(LoteRpsVersao versao) {
    this.versao = versao;
  }

  public BigInteger getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(BigInteger numeroLote) {
    this.numeroLote = ValidadorInteiro.comTamanhoMaximo(15, numeroLote, "Numero do Lote Rps");
  }

  public void setNumeroLote(Long numeroLote) {
    this.numeroLote = ValidadorInteiro.comTamanhoMaximo(15, BigInteger.valueOf(numeroLote), "Numero do Lote Rps");
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

  public Integer getQuantidadeRps() {
    return quantidadeRps;
  }

  public List<NFSeRps> getRps() {
    return Collections.unmodifiableList(listaRps);
  }

  public void addRps(List<NFSeRps> rps) {
    listaRps.addAll(rps);
    quantidadeRps = listaRps.size();
  }

  public void addRps(NFSeRps... rps) {
    addRps(Arrays.asList(rps));
  }
}
