package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;

public class RpsIntermediarioTest {

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDocumentoInvalido() throws Exception {
    try {
      new IntermediarioBuilder("12345678901", "Intermediario Teste").build();
    } catch (final ConstraintViolationException e) {
      new IntermediarioBuilder("12345678901231", "Intermediario Teste").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirNomeTamanhoInvalido() throws Exception {
    try {
      new IntermediarioBuilder("12345678901230", "").build();
    } catch (final ConstraintViolationException e) {
      new IntermediarioBuilder("12345678901230", "CPkcEnGUuCoYLypnrbzTjfJDhfUSAXoSDDzZiqwOVcrQRbtdcpfhNLtRKViUbnsuNXonvSPDgSPFXbkEFtHTopDLUgOxretqfOVvuwIqyhdkkMhyKGfZ").build();
    }
  }
  
}
