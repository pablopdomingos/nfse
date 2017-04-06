package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsSerie;
import com.pablodomingos.classes.rps.enums.RpsTipo;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsIdentificacaoBH extends AbstractRPS {

  @Element(name="Numero")
  @NotNull
  @Pattern(regexp = "\\d+")
  @Size(min=1, max=15)
  private String numero;

  @Element(name="Serie")
  @NotNull
  private RpsSerie serie = RpsSerie.A;

  @Element(name="Tipo")
  @NotNull
  private RpsTipo tipo = RpsTipo.RPS;

  public RpsIdentificacaoBH(String numero) {
    this.numero = numero;
  }

  public RpsIdentificacaoBH(String numero, String serie) {
    this.numero = numero;
    if (serie != null) {
      this.serie = RpsSerie.fromString(serie);
    }
  }

  public RpsIdentificacaoBH(String numero, RpsSerie serie) {
    this.numero = numero;
    if (serie != null)
      this.serie = serie;
  }

  public String getNumero() {
    return numero;
  }

  public RpsSerie getSerie() {
    return serie;
  }

  public void setSerie(RpsSerie serie) {
    this.serie = serie;
  }

  public RpsTipo getTipo() {
    return tipo;
  }

  public void setTipo(RpsTipo tipo) {
    this.tipo = tipo;
  }

}
