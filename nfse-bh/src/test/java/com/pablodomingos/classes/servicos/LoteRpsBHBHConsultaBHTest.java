package com.pablodomingos.classes.servicos;

import com.pablodomingos.FabricaDeObjetosFake;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class LoteRpsBHBHConsultaBHTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRPSConsulta.xml"));
    LoteRpsConsultaBH consultaLoteBH = new LoteRpsConsultaBH("AP1057893n16X103sfhF4RPm", FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaLoteBH.converterParaXml();

    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


