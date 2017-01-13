package com.pablodomingos.classes.rps;

import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class LoteRps {

  
  @XStreamAlias("Id")
  @NotNull
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("versao")
  @NotNull
  @XStreamAsAttribute
  private LoteRpsVersao versao;

  @XStreamAlias("NumeroLote")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=15)
  private String numeroLote;

  @XStreamAlias("Cnpj")
  @NotNull
  @CNPJ
  @Size(min = 14, max = 14)
  private String cnpj;

  @XStreamAlias("InscricaoMunicipal")
  @NotNull
  @Size(min=1, max=15)
  private String inscricaoMunicipal;

  @XStreamAlias("QuantidadeRps")
  @NotNull
  private int quantidadeRps;

  @XStreamAlias("ListaRps")
  @NotNull
  private final List<Rps> listaRps;

  public LoteRps(LoteRpsBuilder builder) {
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

  public List<Rps> getRps() {
    return Collections.unmodifiableList(listaRps);
  }

  
}
