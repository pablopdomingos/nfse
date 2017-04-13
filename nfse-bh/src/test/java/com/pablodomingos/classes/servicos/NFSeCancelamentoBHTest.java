package com.pablodomingos.classes.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.NFSePedidoCancelamentoBH;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class NFSeCancelamentoBHTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    
    NFSePedidoCancelamentoBH nfSePedidoCancelamentoBH = new NFSePedidoCancelamentoBH(FabricaDeObjetosFake.getNFSeInfPedidoCancelamento());
    NFSeCancelamentoBH nfSeCancelamentoBH = new NFSeCancelamentoBH(nfSePedidoCancelamentoBH);
    
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("identificacaoNFSe.xml"));
    String xml = nfSeCancelamentoBH.converterParaXml();

    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


