package com.pablodomingos.assinatura;

import com.pablodomingos.config.CertificadoConfig;

public class AssinaturaDigitalBHISS extends AssinaturaDigital {
  public AssinaturaDigitalBHISS(CertificadoConfig config) {
    super(config);
  }

  @Override
  protected String informacaoRps() {
    return "InfRps";
  }

  @Override
  protected String[] elementosAssinaveis() {
    return new String[]{"LoteRps", "InfPedidoCancelamento"};
  }
}
