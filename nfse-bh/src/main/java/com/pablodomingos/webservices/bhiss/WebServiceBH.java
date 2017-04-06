package com.pablodomingos.webservices.bhiss;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.rps.respostas.EnviarLoteRpsRespostaBH;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.webservices.core.NFSeAbstractStub;
import com.pablodomingos.webservices.core.NFSeAbstractWebService;
import com.pablodomingos.webservices.core.NFSeLocator;
import com.pablodomingos.webservices.core.NFSeWebService;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.net.URL;

public class WebServiceBH extends NFSeAbstractWebService {
    private static final String CABECALHO = "<?xml version='1.0' encoding='UTF-8'?>"
            + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
            + "<versaoDados>1.00</versaoDados>"
            + "</cabecalho>";

    public static EnviarLoteRpsRespostaBH enviarLoteRps(String xml, CertificadoConfig configCertificado) throws Exception {
        return fromXml(EnviarLoteRpsRespostaBH.class, ((OutputBH) webService(configCertificado).recepcionarLoteRps(new InputBH(CABECALHO, xml))).getOutputXML());
    }

    private static NFSeAbstractStub webService(CertificadoConfig configCertificado) throws ServiceException{
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

        return _service.getSOAP();
    }
}
