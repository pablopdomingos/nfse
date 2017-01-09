package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.rps.builders.TomadorEnderecoBuilder;

public class RpsTomadorEnderecoTest {
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirLogradouroComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comLogradouro("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comLogradouro("HlcwIDmQNNGtowjEdSBhVgFtWAixXhKzYOQahOvvaYJVORoEnguOJLufAznzhfwSFgAUBFGNiXAMyWYXjMrUbKiSZREPILiwtZPeIFsMzcdtzUNSIAMhBsSAyZWrXv").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirNumeroComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comNumeroEndereco("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comNumeroEndereco("TZihPtAZUfI").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirComplementoComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comComplemento("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comComplemento("MclUlgdavYvqDKcPsMUSmAAVZQAwlFerffXyqsziSWnihvYHxLFcbPfcKXeIW").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirBairroComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comBairro("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comBairro("DcifpaAuHvgeappsWffEdIQdPLLxmQnoyDJQyMRiLLjgUcpOZncjZNBkaqDjf").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comCodigoMunicipio(00000000).build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comCodigoMunicipio("00000000").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirUfComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comUf("").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comUf("AAA").build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCepComTamanhoInvalido() throws Exception {
    try {
      new TomadorEnderecoBuilder().comCep("0000000").build();
    } catch (final ConstraintViolationException e) {
      new TomadorEnderecoBuilder().comCep("000000000").build();
    }
  }
}
