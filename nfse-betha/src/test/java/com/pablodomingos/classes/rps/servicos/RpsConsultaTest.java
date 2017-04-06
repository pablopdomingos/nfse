package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.RpsIdentificacao;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class RpsConsultaTest {
  @Test
  public void deveGerarXmlRpsConsultaCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(RpsConsultaTest.class.getClassLoader().getResourceAsStream("consultaRPS.xml"));
    RpsConsulta consultaRPS = new RpsConsulta(new RpsIdentificacao("24", "A1"), FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaRPS.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


