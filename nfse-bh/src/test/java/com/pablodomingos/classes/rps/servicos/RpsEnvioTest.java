package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;

public class RpsEnvioTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("envioRPS.xml"));
    RpsEnvio nfseEnvio = new RpsEnvio(FabricaDeObjetosFake.getLoteRps());
    String xml = nfseEnvio.converterParaXml();
    
    Assert.assertEquals(xml, xmlTest);
  }
  
}


