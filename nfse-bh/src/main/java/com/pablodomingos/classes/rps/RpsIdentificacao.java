package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.RpsSerie;
import com.pablodomingos.classes.rps.enums.RpsTipo;
import org.simpleframework.xml.Element;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RpsIdentificacao extends AbstractRPS {

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

  public RpsIdentificacao(String numero) {
    this.numero = numero;
  }

  public RpsIdentificacao(String numero, String serie) {
    this.numero = numero;
    if (serie != null) {
      this.serie = RpsSerie.fromString(serie);
    }
  }

  public RpsIdentificacao(String numero, RpsSerie serie) {
    System.out.println("numero = " + numero);
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
