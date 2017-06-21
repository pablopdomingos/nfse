package com.pablodomingos;

import com.pablodomingos.classes.rps.*;

public class FabricaDeObjetosFake {

  public static RpsTomadorBH getRpsTomador() {
    return new RpsTomadorBH(FabricaDeBuildersFake.getTomadorBuilder());
  }

  public static RpsPrestadorBH getRpsPrestador(){
    return new RpsPrestadorBH(FabricaDeBuildersFake.getRpsPrestadorBuilder());
  }
  
  public static RpsIntermediarioBH getRpsIntermediario(){
    return new RpsIntermediarioBH(FabricaDeBuildersFake.getIntermediarioBuilder());
  }

  public static RpsValoresBH getRpsValores(){
    return new RpsValoresBH(FabricaDeBuildersFake.getValoresBuilder());
  }

  public static RpsServicoBH getRpsServico(){
    return new RpsServicoBH(FabricaDeBuildersFake.getServicoBuilder());
  }
  
  public static RpsBH getRps(){
    return new RpsBH(FabricaDeBuildersFake.getRpsInfoBuilder());
  }
  
  public static LoteRpsBH getLoteRps(){
    return new LoteRpsBH(FabricaDeBuildersFake.getLoteRpsBuilder());
  }

  public static NFSeInfPedidoCancelamentoBH getNFSeInfPedidoCancelamento(){
    return new NFSeInfPedidoCancelamentoBH(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder());
  }
}
