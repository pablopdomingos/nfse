package com.pablodomingos.classes.servicos;

import com.pablodomingos.FabricaDeObjetosFake;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class LoteRpsBHBHConsultaBHSituacaoBHTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRpsConsultaSituacao.xml"));
    LoteRpsConsultaSituacaoBH loteRpsConsultaSituacaoBH = new LoteRpsConsultaSituacaoBH("AP1057893n16X103sfhF4RPm", FabricaDeObjetosFake.getRpsPrestador());
    String xml = loteRpsConsultaSituacaoBH.converterParaXml();

    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


