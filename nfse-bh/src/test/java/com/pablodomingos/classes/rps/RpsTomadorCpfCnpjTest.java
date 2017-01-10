package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.rps.builders.TomadorCpfCnpjBuilder;


public class RpsTomadorCpfCnpjTest {
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDocumentoComTamanhoInvalido() throws Exception {
    try {
      new TomadorCpfCnpjBuilder().comDocumento("1234567890").build();
    } catch (final ConstraintViolationException e) {
      new TomadorCpfCnpjBuilder().comDocumento("123456789090").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDocumentoComLetras() throws Exception {
    try {
      new TomadorCpfCnpjBuilder().comDocumento("12E45678909").build();
    } catch (final ConstraintViolationException e) {
      new TomadorCpfCnpjBuilder().comDocumento("1234567E901230").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDocumentoComPontuacao() throws Exception {
    try {
      new TomadorCpfCnpjBuilder().comDocumento("123.456.789-09").build();
    } catch (final ConstraintViolationException e) {
      new TomadorCpfCnpjBuilder().comDocumento("12.548.785/9856-42").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDocumentoInvalido() throws Exception {
    try {
      new TomadorCpfCnpjBuilder().comDocumento("11111111112").build();
    } catch (final ConstraintViolationException e) {
      new TomadorCpfCnpjBuilder().comDocumento("11111111111112").build();
    }
  }
  
  @Test
  public void deveSetarSomenteCpfQuandoForValido() throws Exception {
    String cpf = "12345678909";
    RpsTomadorCpfCnpj tomadorCpfCnpj = new TomadorCpfCnpjBuilder().comDocumento(cpf).build();
    Assert.assertEquals(tomadorCpfCnpj.getCpf(), cpf);
    Assert.assertEquals(tomadorCpfCnpj.getCnpj(), null);
  }
  
  @Test
  public void deveSetarSomenteCnpjQuandoForValido() throws Exception {
    String cnpj = "12345678901230";
    RpsTomadorCpfCnpj tomadorCpfCnpj = new TomadorCpfCnpjBuilder().comDocumento(cnpj).build();
    Assert.assertEquals(tomadorCpfCnpj.getCnpj(), cnpj);
    Assert.assertEquals(tomadorCpfCnpj.getCpf(), null);
  }
}
