package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import com.pablodomingos.classes.servicos.AbstractServiceBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;

@Root(name = "CancelarNfseEnvio")
public class NfseRetornoCancelamentoBetha extends AbstractServiceBetha {

  @Attribute(name = "versao", required = false)
  private LoteRpsVersao versao;

  @Element(name = "Confirmacao", required = false)
  private Confirmacao confirmacao;

  public static class Confirmacao {

    @Element(name = "Pedido")
    private NfsePedidoCancelamentoBetha pedido;

    @Element(name = "DataHora", required = false)
    private LocalDateTime dataHora;

    public NfsePedidoCancelamentoBetha getPedido() {
      return pedido;
    }

    public LocalDateTime getDataHora() {
      return dataHora;
    }
  }

  public LoteRpsVersao getVersao() {
    return versao;
  }

  public Confirmacao getConfirmacao() {
    return confirmacao;
  }
}
