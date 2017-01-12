package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;

public class LoteRpsEnvioTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("loteRPSEnvio.xml"));
    LoteRpsEnvio loteRpsEnvio = new LoteRpsEnvio(FabricaDeObjetosFake.getLoteRps());
    String xml = loteRpsEnvio.converterParaXml();
    
    Assert.assertEquals(xml, xmlTest);
  }
  
}


