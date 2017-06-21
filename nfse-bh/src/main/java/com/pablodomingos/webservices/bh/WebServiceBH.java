package com.pablodomingos.webservices.bh;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.respostas.EnviarLoteRpsRespostaBH;
import com.pablodomingos.classes.respostas.GerarNfseRespostaBH;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.util.XmlUtil;
import com.pablodomingos.webservices.core.NFSeAbstractStub;
import com.pablodomingos.webservices.core.NFSeAbstractWebService;
import com.pablodomingos.webservices.core.NFSeLocator;
import com.pablodomingos.webservices.core.NFSeWebService;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class WebServiceBH extends NFSeAbstractWebService {
    private static final String CABECALHO = "<?xml version='1.0' encoding='UTF-8'?>"
            + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
            + "<versaoDados>1.00</versaoDados>"
            + "</cabecalho>";

    public static EnviarLoteRpsRespostaBH enviarLoteRps(String xml, CertificadoConfig configCertificado) throws Exception {
        return XmlUtil.fromXml(EnviarLoteRpsRespostaBH.class, ((OutputBH) webService(configCertificado).recepcionarLoteRps(new InputBH(CABECALHO, xml))).getOutputXML());
    }
    public static GerarNfseRespostaBH gerarNfse(String xml, CertificadoConfig configCertificado) throws Exception {
        return XmlUtil.fromXml(GerarNfseRespostaBH.class, ((OutputBH) webService(configCertificado).gerarNfse(new InputBH(CABECALHO, xml))).getOutputXML());
    }

    private static StubBH webService(CertificadoConfig configCertificado) throws ServiceException, CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
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
            public NFSeAbstractStub getStub(URL endpointURL, Service service) throws AxisFault {
                return new StubBH(endpointURL, service);
            }

            @Override
            public String getSOAPAddress() {
                return null;
            }
        };

        return (StubBH) _service.getSOAP();
    }
}
