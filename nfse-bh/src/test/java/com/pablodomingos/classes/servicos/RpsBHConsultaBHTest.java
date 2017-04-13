package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.RpsIdentificacaoBH;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class RpsBHConsultaBHTest {
  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("consultaRPS.xml"));
    RpsConsultaBH rpsConsultaBH = new RpsConsultaBH(new RpsIdentificacaoBH("1"), FabricaDeObjetosFake.getRpsPrestador());
    String xml = rpsConsultaBH.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


