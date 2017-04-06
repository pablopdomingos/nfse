package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import org.hibernate.validator.constraints.br.CNPJ;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoteRpsBH extends AbstractRPS {
  @Attribute(name = "Id")
  @NotNull
  private String id;

  @Attribute(name = "versao")
  @NotNull
  @Valid
  private LoteRpsVersao versao;

  @Element(name = "NumeroLote")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min = 1, max = 15)
  private String numeroLote;

  @Element(name = "Cnpj")
  @NotNull
  @CNPJ
  @Size(min = 14, max = 14)
  private String cnpj;

  @Element(name = "InscricaoMunicipal")
  @NotNull
  @Size(min = 1, max = 15)
  private String inscricaoMunicipal;

  @Element(name = "QuantidadeRps")
  @NotNull
  private int quantidadeRps;

  @Element(name = "ListaRps")
  @NotNull
  @Valid
  private final List<RpsBH> listaRps = new ArrayList<>();

  public LoteRpsBH(LoteRpsBuilder builder) {
    this.id = builder.getId();
    this.versao = builder.getVersao();
    this.numeroLote = builder.getNumeroLote();
    this.cnpj = builder.getCnpj();
    this.inscricaoMunicipal = builder.getInscricaoMunicipal();
    this.quantidadeRps = builder.getQuantidadeRps();

    for (RpsInfoBuilder rpsInfoBuilder : builder.getListaRps()) {
      this.listaRps.add(new RpsBH(rpsInfoBuilder));
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

  public List<RpsBH> getRps() {
    return Collections.unmodifiableList(listaRps);
  }


}
