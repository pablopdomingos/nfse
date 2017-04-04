package com.pablodomingos.webservices.bhiss;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.config.CertificadoConfig;
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

public class WebServiceBHISS {
    private static final String CABECALHO = "<?xml version='1.0' encoding='UTF-8'?>"
            + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
            + "<versaoDados>1.00</versaoDados>"
            + "</cabecalho>";

    public static String consultarSituacaoLoteRps(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((Output) webService(configCertificado).consultarLoteRps(new Input(CABECALHO, xml))).getOutputXML();
    }

    public static String gerarNfse(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((Output) webService(configCertificado).gerarNfse(new Input(CABECALHO, xml))).getOutputXML();
    }

    private static NFSeAbstract webService(CertificadoConfig configCertificado) throws ServiceException{
        configCertificado.carregarCertificados();

        NFSeWebService _service = new NFSeLocator(configCertificado) {
            @Override
            public String getAddress() {
                if (configCertificado.getAmbiente() == NFSeAmbiente.HOMOLOGACAO)
                {
                    return "https://bhisshomologa.pbh.gov.br:443/bhiss-ws/nfse";
                }
                else
                {
                    return "https://bhissdigital.pbh.gov.br:443/bhiss-ws/nfse";
                }
            }

            @Override
            public String getSoapServiceName() {
                return "nfseSOAP";
            }

            @Override
            public NFSeAbstractStub getStub(URL endpointURL, javax.xml.rpc.Service service) throws AxisFault {
                return new StubBHISS(endpointURL, service);
            }

            @Override
            public String getSOAPAddress() {
                return null;
            }
        };

        return _service.getSOAP();
    }
}
