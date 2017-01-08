package com.pablodomingos.classes.rps.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.pablodomingos.classes.enums.LoteRpsVersao;
import com.pablodomingos.classes.rps.LoteRps;
import com.pablodomingos.classes.rps.Rps;
import com.pablodomingos.validadores.ValidadorString;

public class LoteRpsBuilder {

  private String id;
  private LoteRpsVersao versao;
  private String numeroLote;
  private String cnpj;
  private String inscricaoMunicipal;
  private int quantidadeRps;
  private final List<Rps> listaRps;

  public LoteRpsBuilder(String numeroLote) {
    if (numeroLote == null || numeroLote.isEmpty()) {
      throw new IllegalArgumentException("Numero do lote não pode ser nulo");
    }
    this.numeroLote = ValidadorString.comTamanhoMaximo(15, numeroLote, "Numero do lote");
    this.versao = LoteRpsVersao.V1_00;
    this.listaRps = new ArrayList<Rps>();
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
  
  public LoteRpsBuilder addRps(List<Rps> rps) {
    this.listaRps.addAll(rps);
    this.quantidadeRps = listaRps.size();
    return this;
  }

  public LoteRpsBuilder addRps(Rps... rps) {
    addRps(Arrays.asList(rps));
    return this;
  }
  
  public LoteRps build() {
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

