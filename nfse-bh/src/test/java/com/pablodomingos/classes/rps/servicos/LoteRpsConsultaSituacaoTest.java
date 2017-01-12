package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;

public class LoteRpsConsultaSituacaoTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRpsConsultaSituacao.xml"));
    LoteRpsConsultaSituacao consultaSituacaoLote = new LoteRpsConsultaSituacao("AP1057893n16X103sfhF4RPm", FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaSituacaoLote.converterParaXml();
    
    Assert.assertEquals(xml, xmlTest);
  }
  
}


