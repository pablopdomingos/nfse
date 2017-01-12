package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;

public class RpsTomadorEnderecoTest {

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirLogradouroComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
        .comLogradouro("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comLogradouro("HlcwIDmQNNGtowjEdSBhVgFtWAixXhKzYOQahOvvaYJVORoEnguOJLufAznzhfwSFgAUBFGNiXAMyWYXjMrUbKiSZREPILiwtZPeIFsMzcdtzUNSIAMhBsSAyZWrXv").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirNumeroComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comNumeroEndereco("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comNumeroEndereco("TZihPtAZUfI").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirComplementoComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comComplemento("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comComplemento("MclUlgdavYvqDKcPsMUSmAAVZQAwlFerffXyqsziSWnihvYHxLFcbPfcKXeIW").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirBairroComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comBairro("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comBairro("DcifpaAuHvgeappsWffEdIQdPLLxmQnoyDJQyMRiLLjgUcpOZncjZNBkaqDjf").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comCodigoMunicipio("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comCodigoMunicipio("00000000").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirUfComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comUf("").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comUf("AAA").build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCepComTamanhoInvalido() throws Exception {
    try {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comCep("0000000").build();
    } catch (final ConstraintViolationException e) {
      FabricaDeObjetosFake.getTomadorEnderecoBuilder()
      .comCep("000000000").build();
    }
  }
}
