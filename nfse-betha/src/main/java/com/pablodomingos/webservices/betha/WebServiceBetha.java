package com.pablodomingos.webservices.betha;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.util.XmlUtil;
import com.pablodomingos.webservices.core.NFSeAbstract;
import com.pablodomingos.webservices.core.NFSeAbstractStub;
import com.pablodomingos.webservices.core.NFSeLocator;
import com.pablodomingos.webservices.core.NFSeWebService;
import org.apache.axis.AxisFault;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class WebServiceBetha {
//    private static final String CABECALHO = "<cabecalho xmlns=\"http://www.betha.com.br/e-nota-contribuinte-ws\" versao=\"2.02\"><versaoDados>2.02</versaoDados></cabecalho>";

    private static final String CABECALHO = "<?xml version='1.0' encoding='UTF-8'?>"
            + "<cabecalho xmlns=\"http://www.betha.com.br/e-nota-contribuinte-ws\" versao=\"2.02\">"
            + "<versaoDados>2.02</versaoDados>"
            + "</cabecalho>";

    public static String consultarSituacaoLoteRps(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((Output) webService(configCertificado).consultarLoteRps(geraParametros(xml))).getOutputXML();
    }

    public static String gerarNfse(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((String) webService(configCertificado).gerarNfse(CABECALHO, xml));
    }


    private static Input geraParametros(String xml){

        Input parametro = new Input();
        parametro.setNfseCabecMsg(XmlUtil.getCabecMsg());

        parametro.setNfseDadosMsg(xml);
        return parametro;

    }


    private static NFSeAbstract webService(CertificadoConfig configCertificado) throws ServiceException{
        configCertificado.carregarCertificados();

        NFSeWebService _service = new NFSeLocator(configCertificado) {
            @Override
            public String getAddress() {
                if (configCertificado.getAmbiente() == NFSeAmbiente.HOMOLOGACAO)
                {
                    return "http://e-gov.betha.com.br/e-nota-contribuinte-test-ws/nfseWS";
                }
                else
                {
                    return "http://e-gov.betha.com.br/e-nota-contribuinte-ws/nfseWS";
                }
            }

            @Override
            public String getSoapServiceName() {
                return "nfseSOAP";
            }

            @Override
            public NFSeAbstractStub getStub(URL endpointURL, javax.xml.rpc.Service service) throws AxisFault {
                return new StubBetha(endpointURL, service);
            }

            @Override
            public String getSOAPAddress() {
                return null;
            }
        };

        return _service.getSOAP();
    }
}
