package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.rps.builders.TomadorContatoBuilder;

public class RpsTomadorContatoTest {
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirTelefoneComTamanhoInvalido() throws Exception {
    try {
      new TomadorContatoBuilder().comTelefone("").build();
    } catch (final ConstraintViolationException  e) {
      new TomadorContatoBuilder().comTelefone("000000000000").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirEmailComTamanhoInvalido() {
    try {
      new TomadorContatoBuilder().comEmail("").build();
    } catch (final ConstraintViolationException  e) {
      new TomadorContatoBuilder().comEmail("SXGgQdNNNvWUFxwUtebbmkccBkVlcMAnxPVPgzIYzAfRHSEAOVxciVTGCkqXQVdeGoUCHlRGWWVYbwyLw").build();
    }
  }
  
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirEmailInvalido() {
    try {
      new TomadorContatoBuilder().comEmail("testecom").build();
    } catch (final ConstraintViolationException  e) {
      new TomadorContatoBuilder().comEmail("teste.com").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void soPermitirTelefoneComNumeros() throws Exception {
    try {
      new TomadorContatoBuilder().comTelefone("E0000000000").build();
    } catch (final ConstraintViolationException  e) {
      new TomadorContatoBuilder().comTelefone("(0000000000").build();
    }
  }
  
}
