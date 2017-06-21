package com.pablodomingos.utils;

import com.pablodomingos.util.NFSeGeraCadeiaCertificados;

import java.util.HashMap;
import java.util.Map;

public abstract class NFSeGeraCadeiaCertificadosBetha {
  public static byte[] geraCadeiaCertificados(String senha) throws Exception {
    Map<String, Integer> enderecos = new HashMap<>();
    enderecos.put("e-gov.betha.com.br", 443);
    return NFSeGeraCadeiaCertificados.geraCadeiaCertificados(enderecos, senha);
  }
}
