package com.pablodomingos.classes;

import com.pablodomingos.classes.rps.*;
import com.pablodomingos.util.FabricaDeBuildersFake;

public class FabricaDeObjetosFake {

  public static RpsTomador getRpsTomador() {
    return new RpsTomador(FabricaDeBuildersFake.getTomadorBuilder());
  }

  public static RpsPrestador getRpsPrestador(){
    return new RpsPrestador(FabricaDeBuildersFake.getRpsPrestadorBuilder());
  }
  
  public static RpsIntermediario getRpsIntermediario(){
    return new RpsIntermediario(FabricaDeBuildersFake.getIntermediarioBuilder());
  }

  public static RpsValores getRpsValores(){
    return new RpsValores(FabricaDeBuildersFake.getValoresBuilder());
  }

  public static RpsServico getRpsServico(){
    return new RpsServico(FabricaDeBuildersFake.getServicoBuilder());
  }
  
  public static Rps getRps(){
    return new Rps(FabricaDeBuildersFake.getRpsInfoBuilder());
  }
  
  public static LoteRps getLoteRps(){
    return new LoteRps(FabricaDeBuildersFake.getLoteRpsBuilder());
  }

  public static NFSeInfPedidoCancelamento getNFSeInfPedidoCancelamento(){
    return new NFSeInfPedidoCancelamento(FabricaDeBuildersFake.getPedidoCancelamentoInfBuilder());
  }
}
