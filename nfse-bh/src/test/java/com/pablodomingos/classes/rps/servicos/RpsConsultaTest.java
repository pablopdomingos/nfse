package com.pablodomingos.classes.rps.servicos;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.RpsIdentificacao;

public class RpsConsultaTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("consultaRPS.xml"));
    RpsConsulta consultaRPS = new RpsConsulta(new RpsIdentificacao("1"), FabricaDeObjetosFake.getRpsPrestador());
    String xml = consultaRPS.converterParaXml();
    
    Assert.assertEquals(xml, xmlTest);
  }
  
}


