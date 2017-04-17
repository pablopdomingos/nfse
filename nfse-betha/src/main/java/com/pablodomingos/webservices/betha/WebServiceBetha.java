package com.pablodomingos.webservices.betha;

import com.pablodomingos.classes.respostas.*;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.util.XmlUtil;
import com.pablodomingos.webservices.core.NFSeAbstractStub;
import com.pablodomingos.webservices.core.NFSeAbstractWebService;
import com.pablodomingos.webservices.core.NFSeLocator;
import com.pablodomingos.webservices.core.NFSeWebService;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.net.URL;

public class WebServiceBetha extends NFSeAbstractWebService {
  private static final String CABECALHO = "<?xml version='1.0' encoding='UTF-8'?>"
      + "<cabecalho xmlns=\"http://www.betha.com.br/e-nota-contribuinte-ws\" versao=\"2.02\">"
      + "<versaoDados>2.02</versaoDados>"
      + "</cabecalho>";

//  public static String consultaSituacaoLoteRps(String xml, CertificadoConfig configCertificado)
//      throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
//      IOException {
//
//    return webService(configCertificado).consultarSituacaoLoteRps(xml).toString();
//  }

  public static GerarNfseRespostaBetha gerarNfse(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(GerarNfseRespostaBetha.class, webService(configCertificado).gerarNfse(CABECALHO, xml));
  }

  public static CancelarNfseRespostaBetha cancelarNfse(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(CancelarNfseRespostaBetha.class, webService(configCertificado).cancelarNfse(CABECALHO, xml));
  }

  public static EnviarLoteRpsRespostaBetha enviarLoteRps(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(EnviarLoteRpsRespostaBetha.class, webService(configCertificado).recepcionarLoteRps(CABECALHO, xml));
  }

  public static ConsultarLoteRpsRespostaBetha consultarLoteRps(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(ConsultarLoteRpsRespostaBetha.class, webService(configCertificado).consultarLoteRps(CABECALHO, xml));
  }

  public static ConsultarNfseServicoPrestadoRespostaBetha consultarNfseServicoPrestado(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(ConsultarNfseServicoPrestadoRespostaBetha.class, webService(configCertificado).consultarNfseServicoPrestado(CABECALHO, xml));
  }

  public static ConsultarNfseServicoTomadoRespostaBetha consultarNfseServicoTomado(String xml, CertificadoConfig configCertificado) throws Exception {
    return XmlUtil.fromXml(ConsultarNfseServicoTomadoRespostaBetha.class, webService(configCertificado).consultarNfseServicoTomado(CABECALHO, xml));
  }


  private static StubBetha webService(CertificadoConfig configCertificado) throws ServiceException {
    configCertificado.carregarCertificados();

    NFSeWebService _service = new NFSeLocator(configCertificado) {
      @Override
      public String getAddress() {
        if (configCertificado.getAmbiente() == NFSeAmbiente.HOMOLOGACAO) {
          return "http://e-gov.betha.com.br/e-nota-contribuinte-test-ws/nfseWS";
        } else {
          return "";
//          return "http://e-gov.betha.com.br/e-nota-contribuinte-ws/nfseWS";
        }
      }

      @Override
      public String getSoapServiceName() {
        return "nfseSOAP";
      }

      @Override
      public NFSeAbstractStub getStub(URL endpointURL, Service service) throws AxisFault {
        return new StubBetha(endpointURL, service);
      }

      @Override
      public String getSOAPAddress() {
        return null;
      }
    };

    return (StubBetha) _service.getSOAP();
  }
}