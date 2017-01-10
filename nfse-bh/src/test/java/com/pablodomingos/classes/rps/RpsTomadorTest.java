package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.rps.builders.TomadorBuilder;

public class RpsTomadorTest {
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirNomeComTamanhoInvalido() throws Exception {
    try {
      new TomadorBuilder("12345678909")
        .comNome("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorBuilder("12345678909")
      .comNome("CPkcEnGUuCoYLypnrbzTjfJDhfUSAXoSDDzZiqwOVcrQRbtdcpfhNLtRKViUbnsuNXonvSPDgSPFXbkEFtHTopDLUgOxretqfOVvuwIqyhdkkMhyKGfZ").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirInscricaoMunicipalComTamanhoInvalido() throws Exception {
    try {
      new TomadorBuilder("12345678909")
        .comInscricaoMunicipal("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorBuilder("12345678909")
      .comInscricaoMunicipal("0000000000000000").build();
    }
  }
}
