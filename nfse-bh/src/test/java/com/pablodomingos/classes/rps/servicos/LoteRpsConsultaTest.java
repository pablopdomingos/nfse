package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;

public class LoteRpsConsultaTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRPSConsulta.xml"));
    LoteRpsConsulta consultaLote = new LoteRpsConsulta("AP1057893n16X103sfhF4RPm", FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaLote.converterParaXml();
    
    Assert.assertEquals(xml, xmlTest);
  }
  
}


