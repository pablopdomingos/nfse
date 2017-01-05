package com.pablodomingos.validadores;

import java.math.BigInteger;

public class ValidadorInteiro {

  public static BigInteger comTamanhoMaximo(int maxTamanho, BigInteger valor, String info) {
    if (String.valueOf(valor).length() > maxTamanho) {
      throw new NumberFormatException("Valor excedeu o tamanho do campo " + info);
    } else {
      return valor;
    }
  }
  
  public static Integer comTamanhoMaximo(int maxTamanho, Integer valor, String info) {
    if (String.valueOf(valor).length() > maxTamanho) {
      throw new NumberFormatException("Valor excedeu o tamanho do campo " + info);
    } else {
      return valor;
    }
  }
  
  public static BigInteger comTamanhoExato(int tamanho, BigInteger valor, String info) {
    if (String.valueOf(valor).length() == tamanho) {
      throw new NumberFormatException("Valor do campo "+info+" deve ter o tamanho igual a " + tamanho);
    } else {
      return valor;
    }
  }
}
