package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class ConsultarNFSeRespostaTest {

  @Test
  public void quandoSucessoPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest =
        IOUtils.toString(getClass().getClassLoader().getResourceAsStream("gerarNfseResposta.xml"));

    GerarNFSeResposta pojo = GerarNFSeResposta.toPojo(xmlTest);
    assertEquals("201411181158", pojo.getNumeroLote().toString());
    assertEquals("2014-11-18T11:05:21", pojo.getDataRecebimento().toString());
    assertEquals("Sb0164841F20140000000004", pojo.getProtocolo());
    assertNotNull(pojo.getListaNfse());
    assertTrue(!pojo.getListaNfse().getCompNfse().isEmpty());
    assertNotNull(pojo.getListaNfse().getCompNfse().get(0));
    assertNotNull(pojo.getListaNfse().getCompNfse().get(0).getNfse());

  }
  
  @Test
  public void quandoErroPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest =
        IOUtils.toString(getClass().getClassLoader().getResourceAsStream("erroGerarNfseResposta.xml"));

    GerarNFSeResposta pojo = GerarNFSeResposta.toPojo(xmlTest);
    assertNotNull(pojo.getListaMensagemRetorno());

  }
}
