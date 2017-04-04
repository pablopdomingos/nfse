package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoteRps extends AbstractRPS {
  @XStreamAlias("Id")
  @NotNull
  @XStreamAsAttribute
  private String id;

  @XStreamAlias("versao")
  @NotNull
  @XStreamAsAttribute
  @Valid
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
  @Valid
  private final List<Rps> listaRps = new ArrayList<>();

  public LoteRps(LoteRpsBuilder builder) {
    this.id = builder.getId();
    this.versao = builder.getVersao();
    this.numeroLote = builder.getNumeroLote();
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
    this.quantidadeRps = builder.getQuantidadeRps();

    for (RpsInfoBuilder rpsInfoBuilder : builder.getListaRps()) {
      this.listaRps.add(new Rps(rpsInfoBuilder));
    }

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
