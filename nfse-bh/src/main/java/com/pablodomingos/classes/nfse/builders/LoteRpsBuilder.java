package com.pablodomingos.classes.nfse.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.pablodomingos.classes.nfse.NFSeLoteRps;
import com.pablodomingos.classes.nfse.NFSeRps;
import com.pablodomingos.classes.nfse.enums.LoteRpsVersao;
import com.pablodomingos.validadores.ValidadorString;

public class LoteRpsBuilder {

  private String id;
  private LoteRpsVersao versao;
  private String numeroLote;
  private String cnpj;
  private String inscricaoMunicipal;
  private int quantidadeRps;
  private final List<NFSeRps> listaRps;

  public LoteRpsBuilder(String numeroLote) {
    if (numeroLote == null || numeroLote.isEmpty()) {
      throw new IllegalArgumentException("Numero do lote não pode ser nulo");
    }
    this.numeroLote = ValidadorString.comTamanhoMaximo(15, numeroLote, "Numero do lote");
    this.versao = LoteRpsVersao.V1_00;
    this.listaRps = new ArrayList<NFSeRps>();
    this.id = UUID.randomUUID().toString();
  }
  
  public LoteRpsBuilder comId(String id) {
    this.id = ValidadorString.comTamanhoMaximo(255, id, "Id do lote");
    return this;
  }
  
  public LoteRpsBuilder comVersao(LoteRpsVersao versao) {
    this.versao = versao;
    return this;
  }
  
  public LoteRpsBuilder comCnpj(String cnpj) {
    this.cnpj = ValidadorString.comTamanhoExato(14, cnpj, "Cnpj do lote");
    return this;
  }

  public LoteRpsBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal do lote");
    return this;
  }
  
  public LoteRpsBuilder addRps(List<NFSeRps> rps) {
    this.listaRps.addAll(rps);
    this.quantidadeRps = listaRps.size();
    return this;
  }

  public LoteRpsBuilder addRps(NFSeRps... rps) {
    addRps(Arrays.asList(rps));
    return this;
  }
  
  public NFSeLoteRps build() {
    return new NFSeLoteRps(this);
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

  public int getQuantidadeRps() {
    return quantidadeRps;
  }

  public List<NFSeRps> getListaRps() {
    return Collections.unmodifiableList(listaRps);
  }

}

