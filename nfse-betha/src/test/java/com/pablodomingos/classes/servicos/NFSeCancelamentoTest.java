package com.pablodomingos.classes.servicos;

import com.pablodomingos.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.NfsePedidoCancelamentoBetha;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class NFSeCancelamentoTest {

  @Test
  public void deveGerarXmlCancelamentoCorretamente() throws IOException{
    NfsePedidoCancelamentoBetha pedido = new NfsePedidoCancelamentoBetha(FabricaDeObjetosFake.getNFSeInfPedidoCancelamento());
    NFSeCancelamentoBetha nfseCancelamento = new NFSeCancelamentoBetha(pedido);
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("identificacaoNFSe.xml"));
    String xml = nfseCancelamento.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


