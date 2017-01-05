package com.pablodomingos.validadores;

public class ValidadorString {

  public static String comTamanhoMaximo(int tamanho, String valor, String info) {
    String valorString = String.valueOf(valor);
    if (valorString.length() > tamanho) {
      throw new NumberFormatException("Valor extrapolou o tamanho do campo " + info);
    } else {
      return valorString;
    }
  }

  public static String comTamanhoMaximoEMinimo(int tamanhoMax, int tamanhoMin , String valor, String info) {
    String valorString = String.valueOf(valor);
    if (valorString.length() > tamanhoMax || valorString.length() < tamanhoMin) {
      throw new NumberFormatException("Valor extrapolou o tamanho do campo " + info);
    } else {
      return valorString;
    }
  }
  
  public static String comTamanhoExato(int tamanho, String valor, String info) {
    if (valor.length() == tamanho) {
      throw new NumberFormatException("Valor do campo "+info+" deve ter o tamanho igual a " + tamanho);
    } else {
      return valor;
    }
  }

}
