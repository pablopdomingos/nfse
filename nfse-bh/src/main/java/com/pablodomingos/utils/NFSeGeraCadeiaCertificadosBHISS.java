package com.pablodomingos.utils;

import com.pablodomingos.util.NFSeGeraCadeiaCertificados;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public abstract class NFSeGeraCadeiaCertificadosBHISS {
  public static byte[] geraCadeiaCertificados(String senha) throws Exception {
    Map<String, Integer> enderecos = new HashMap<>();
    enderecos.put("bhisshomologa.pbh.gov.br", 443);
    enderecos.put("bhissdigital.pbh.gov.br", 443);
    return NFSeGeraCadeiaCertificados.geraCadeiaCertificados(enderecos, senha);
  }
}
