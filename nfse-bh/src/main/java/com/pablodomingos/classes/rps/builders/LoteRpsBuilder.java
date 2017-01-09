package com.pablodomingos.classes.rps.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.pablodomingos.classes.rps.LoteRps;
import com.pablodomingos.classes.rps.Rps;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;

public class LoteRpsBuilder extends AbstractBuilder<LoteRps>{


  private String id;
  private LoteRpsVersao versao;
  private String numeroLote;
  private String cnpj;
  private String inscricaoMunicipal;
  private int quantidadeRps;
  private final List<Rps> listaRps;

  public LoteRpsBuilder(String numeroLote) {
    this.numeroLote = numeroLote;
    this.versao = LoteRpsVersao.V1_00;
    this.listaRps = new ArrayList<Rps>();
    this.id = UUID.randomUUID().toString();
  }
  
  public LoteRpsBuilder comId(String id) {
    this.id = id;
    return this;
  }
  
  public LoteRpsBuilder comVersao(LoteRpsVersao versao) {
    this.versao = versao;
    return this;
  }
  
  public LoteRpsBuilder comCnpj(String cnpj) {
    this.cnpj = cnpj;
    return this;
  }

  public LoteRpsBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  public LoteRpsBuilder addRps(List<Rps> rps) {
    this.listaRps.addAll(rps);
    this.quantidadeRps = listaRps.size();
    return this;
  }

  public LoteRpsBuilder addRps(Rps... rps) {
    addRps(Arrays.asList(rps));
    return this;
  }
  
  @Override
  protected LoteRps buildInternal() {
    return new LoteRps(this);
  }

  public String getId() {
    return this.id;
  }

  public LoteRpsVersao getVersao() {
    return this.versao;
  }

  public String getNumeroLote() {
    return this.numeroLote;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public String getInscricaoMunicipal() {
    return this.inscricaoMunicipal;
  }

  public int getQuantidadeRps() {
    return this.quantidadeRps;
  }

  public List<Rps> getListaRps() {
    return this.listaRps;
  }

}

