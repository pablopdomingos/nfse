package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class LoteRpsConsultaTest {

  @Test
  public void deveGerarXmlLoteRpsConsultaCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRPSConsulta.xml"));
    LoteRpsConsulta consultaLote = new LoteRpsConsulta("141542179222170", FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaLote.converterParaXml();

    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


