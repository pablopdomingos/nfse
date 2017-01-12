package com.pablodomingos.classes.rps.servicos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.junit.Assert;
import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.NFSePedidoCancelamento;

public class NFSeCancelamentoTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    
    NFSePedidoCancelamento pedido = new NFSePedidoCancelamento(FabricaDeObjetosFake.getNFSeInfPedidoCancelamento());
    NFSeCancelamento nfseCancelamento = new NFSeCancelamento(pedido);
    
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("identificacaoNFSe.xml"));
    String xml = nfseCancelamento.converterParaXml();
    FileUtils.writeStringToFile(new File("identificacaoNFSe.xml"), xml.toString());
    Assert.assertEquals(xml, xmlTest);
  }
  
}


