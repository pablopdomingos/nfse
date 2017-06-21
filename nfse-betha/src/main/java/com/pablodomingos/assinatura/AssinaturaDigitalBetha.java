package com.pablodomingos.assinatura;

import com.pablodomingos.config.CertificadoConfig;

public class AssinaturaDigitalBetha extends AssinaturaDigital {
  public AssinaturaDigitalBetha(CertificadoConfig config) {
    super(config);
  }

  @Override
  protected String informacaoRps() {
    return "InfDeclaracaoPrestacaoServico";
  }

  @Override
  protected String[] elementosAssinaveis() {
    return new String[]{"LoteRps", "InfPedidoCancelamento"};
  }
}
