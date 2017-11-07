package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class GerarLoteRpsRespostaTest {

  @Test
  public void quandoSucessoPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest = IOUtils
        .toString(getClass().getClassLoader().getResourceAsStream("consultarLoteRpsResposta.xml"));

    ConsultarLoteRpsResposta pojo = ConsultarLoteRpsResposta.toPojo(xmlTest);
    assertNotNull(pojo.getListaNfse());
    assertNotNull(pojo.getListaNfse().getCompNfse().get(0));
    assertNotNull(pojo.getListaNfse().getCompNfse().get(0).getNfse());
    assertNotNull(pojo.getListaNfse().getCompNfse().get(0).getNfse().getInfNfse());
  }

  @Test
  public void quandoErroPojoDeveSerGeradoCorretamente() throws IOException {
    String xmlTest = IOUtils
        .toString(getClass().getClassLoader().getResourceAsStream("erroConsultarLoteRpsResposta.xml"));

    ConsultarLoteRpsResposta pojo = ConsultarLoteRpsResposta.toPojo(xmlTest);
    assertNotNull(pojo.getListaMensagemRetornoLote());

  }
}
