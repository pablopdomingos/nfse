package com.pablodomingos.util;

public class XmlUtil {

  private static String cabecMsg = "<?xml version='1.0' encoding='UTF-8'?>"
      + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
      + "<versaoDados>1.00</versaoDados>"
      + "</cabecalho>";

  public static String getCabecMsg() {
    return cabecMsg;
  }
  
}
