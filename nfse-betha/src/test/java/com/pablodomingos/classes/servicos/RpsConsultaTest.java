package com.pablodomingos.classes.servicos;

import com.pablodomingos.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.RpsIdentificacaoBetha;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class RpsConsultaTest {
  @Test
  public void deveGerarXmlRpsConsultaCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(RpsConsultaTest.class.getClassLoader().getResourceAsStream("consultaRPS.xml"));
    RpsConsultaBetha consultaRPS = new RpsConsultaBetha(new RpsIdentificacaoBetha("24", "A1"), FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaRPS.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


