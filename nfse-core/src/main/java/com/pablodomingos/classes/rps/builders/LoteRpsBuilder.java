package com.pablodomingos.classes.rps.builders;

import com.pablodomingos.classes.rps.enums.LoteRpsVersao;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class LoteRpsBuilder extends AbstractBuilder {

  private String id;
  private LoteRpsVersao versao;
  private String numeroLote;
  private String cpf;
  private String cnpj;
  private String inscricaoMunicipal;
  private int quantidadeRps;
  private final List<RpsInfoBuilder> listaRps;

  public LoteRpsBuilder(String numeroLote) {
    this.numeroLote = numeroLote;
    this.versao = LoteRpsVersao.V1_00;
    this.listaRps = new ArrayList<RpsInfoBuilder>();
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
  
  public LoteRpsBuilder comDocumento(String documento) {
    if (documento.length() == 14)
      this.cnpj = documento;
    else
      this.cpf = documento;
    return this;
  }

  public LoteRpsBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }
  
  public LoteRpsBuilder addRps(List<RpsInfoBuilder> rps) {
    this.listaRps.addAll(rps);
    this.quantidadeRps = listaRps.size();
    return this;
  }

  public LoteRpsBuilder addRps(RpsInfoBuilder... rps) {
    addRps(Arrays.asList(rps));
    return this;
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

  public String getCpf() {
    return cpf;
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

  public List<RpsInfoBuilder> getListaRps() {
    return this.listaRps;
  }
}

