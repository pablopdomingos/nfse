package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.rps.builders.PrestadorBuilder;

public class RpsPrestadorTest {

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCnpjTamanhoInvalido() throws Exception {
    try {
      new PrestadorBuilder("").build();
    } catch (final ConstraintViolationException e) {
      new PrestadorBuilder("123456789012300").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCnpjInvalido() throws Exception {
    new PrestadorBuilder("12345678901231").build();
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirInscricaoMunicipalTamanhoInvalido() throws Exception {
    try {
      new PrestadorBuilder("12345678901230").comInscricaoMunicipal("").build();
    } catch (final ConstraintViolationException e) {
      new PrestadorBuilder("12345678901230").comInscricaoMunicipal("0000000000000000").build();
    }
  }
}
