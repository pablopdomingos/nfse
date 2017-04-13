package com.pablodomingos.classes;

import com.pablodomingos.classes.rps.*;

public class FabricaDeObjetosFake {

  public static RpsTomadorBetha getRpsTomador() {
    return new RpsTomadorBetha(FabricaDeBuildersFake.getTomadorBuilder());
  }

  public static RpsPrestadorBetha getRpsPrestador(){
    return new RpsPrestadorBetha(FabricaDeBuildersFake.getRpsPrestadorBuilder());
  }
  
  public static RpsIntermediarioBetha getRpsIntermediario(){
    return new RpsIntermediarioBetha(FabricaDeBuildersFake.getIntermediarioBuilder());
  }

  public static RpsValoresBetha getRpsValores(){
    return new RpsValoresBetha(FabricaDeBuildersFake.getValoresBuilder());
  }

  public static RpsServicoBetha getRpsServico(){
    return new RpsServicoBetha(FabricaDeBuildersFake.getServicoBuilder());
  }
  
  public static RpsBetha getRps(){
    return new RpsBetha(FabricaDeBuildersFake.getRpsInfoBuilder());
  }
  
  public static LoteRpsBetha getLoteRps(){
    return new LoteRpsBetha(FabricaDeBuildersFake.getLoteRpsBuilder());
  }

  public static NfseInfPedidoCancelamentoBetha getNFSeInfPedidoCancelamento(){
    return new NfseInfPedidoCancelamentoBetha(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder());
  }
}
