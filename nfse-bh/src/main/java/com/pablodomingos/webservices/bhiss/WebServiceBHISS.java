package com.pablodomingos.webservices.bhiss;

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

public class WebServiceBHISS {
    public static String consultarSituacaoLoteRps(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((Output) webService(configCertificado).consultarLoteRps(geraParametros(xml))).getOutputXML();
    }

    public static String gerarNfse(String xml, CertificadoConfig configCertificado)
            throws ServiceException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException {

        return ((Output) webService(configCertificado).gerarNfse(geraParametros(xml))).getOutputXML();
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
