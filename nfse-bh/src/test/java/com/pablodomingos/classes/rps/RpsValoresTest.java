package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.rps.builders.ValoresBuilder;

public class RpsValoresTest {
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirValorMenorOuIgualZeroParaServico() throws Exception {
    try {
      new ValoresBuilder(-1.00, 1.0).build();
    } catch (final ConstraintViolationException e) {
      new ValoresBuilder(0.00, 1.0).build();
    }
  }
  
  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDeducoesMaioresOuIguaisServico() throws Exception {
    RpsValores valores = new ValoresBuilder(44.00, 1.0)
        .comValorPis(2.00)
        .comValorCofins(3.00)
        .comValorInss(4.00)
        .comValorIr(5.00)
        .comValorCsll(6.00)
        .comDescontoCondicionado(7.00)
        .comDescontoIncondicionado(8.00)
        .comOutrasRetencoes(9.00)
        .comIssRetido(false)
        .build();
    System.out.println(valores.getValorLiquido());
  }
  
  @Test
  public void valoresDevemSerCalculadosCorretamente() throws Exception {
      RpsValores valores = new ValoresBuilder(56.23, 1.0)
        .comValorPis(2.00)
        .comValorCofins(3.00)
        .comValorInss(4.00)
        .comValorIr(5.00)
        .comValorCsll(6.00)
        .comValorDeducoes(7.00)
        .comDescontoCondicionado(8.00)
        .comDescontoIncondicionado(9.00)
        .comOutrasRetencoes(10.00)
        .comIssRetido(true)
        .build();
      Assert.assertEquals(valores.getValorLiquido(), 8.67, 0);
      Assert.assertEquals(valores.getValorIssRetido(), 0.56, 0);
      Assert.assertEquals(valores.getValorServicos(), 56.23, 0);
      Assert.assertEquals(valores.getValorIss(), null);
  }
  
  @Test
  public void valorIssDeveSerCalculadoCorretamente() throws Exception {
      RpsValores valores = new ValoresBuilder(50.00, 2.0)
        .comIssRetido(false)
        .build();
      Assert.assertEquals(valores.getValorIss(), 1.00, 0);
      Assert.assertEquals(valores.getValorLiquido(), 50.00, 0);
      Assert.assertEquals(valores.getAliquota(), 0.02, 0);
  }
  
  @Test
  public void valorIssRetidoDeveSerCalculadoCorretamente() throws Exception {
      RpsValores valores = new ValoresBuilder(50.00, 2.0)
        .comIssRetido(true)
        .build();
      Assert.assertEquals(valores.getValorIssRetido(), 1.00, 0);
      Assert.assertEquals(valores.getValorLiquido(), 49.00, 0);
      Assert.assertEquals(valores.getAliquota(), 0.02, 0);
  }
  
}
