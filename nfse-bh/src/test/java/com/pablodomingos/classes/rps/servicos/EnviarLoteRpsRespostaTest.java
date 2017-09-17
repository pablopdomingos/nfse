package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class EnviarLoteRpsRespostaTest {

  @Test
  public void quandoSucessoPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest =
        IOUtils.toString(getClass().getClassLoader().getResourceAsStream("enviarLoteRpsResposta.xml"));

    EnviarLoteRpsResposta pojo = EnviarLoteRpsResposta.toPojo(xmlTest);
    assertEquals("1", pojo.getNumeroLote().toString());
    assertEquals("2009-09-25T12:57:07", pojo.getDataRecebimento().toString());
    assertEquals("Ak0591217L2009q000000006", pojo.getProtocolo());

  }
  
  @Test
  public void quandoErroPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest =
        IOUtils.toString(getClass().getClassLoader().getResourceAsStream("erroEnviarLoteRpsResposta.xml"));

    GerarNFSeResposta pojo = GerarNFSeResposta.toPojo(xmlTest);
    assertNotNull(pojo.getListaMensagemRetorno());

  }
}
