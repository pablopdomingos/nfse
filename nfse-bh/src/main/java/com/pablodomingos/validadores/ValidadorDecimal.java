package com.pablodomingos.validadores;

public class ValidadorDecimal {

  public static Double tamanho15Com2CasasDecimais(Double valor) {
    return validadorDecimal(valor, 16, 2);
  }

  public static Double tamanho5Com4CasasDecimais(Double valor) {
    return validadorDecimal(valor, 6, 4);
  }

  private static Double validadorDecimal(Double valor, int tamanhoMax, int maxDigitosFracao) {
    if (valor == null) {
      return null;
    }
    String valorString = valor.toString();
    if (valorString.length() > tamanhoMax
        || valorString.split("\\.")[0].length() > (tamanhoMax - (maxDigitosFracao + 1))
        || valorString.split("\\.")[1].length() > maxDigitosFracao) {
      
      throw new NumberFormatException("O valor " + valor + " excedeu o tamanho do campo");
    }
    return valor;
  }
}
