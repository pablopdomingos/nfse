package com.pablodomingos.webservices.core;

import com.pablodomingos.config.CertificadoConfig;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;

import java.net.URL;

public abstract class NFSeLocator extends Service implements NFSeWebService {

    public abstract String getAddress();
    public abstract String getSoapServiceName();
    public abstract NFSeAbstractStub getStub(URL endpointURL, javax.xml.rpc.Service service) throws AxisFault;

    private CertificadoConfig certificadoConfig;

    public NFSeLocator(CertificadoConfig certificadoConfig) {
        this.certificadoConfig = certificadoConfig;
    }

    public NFSeAbstract getSOAP() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(getAddress());
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAP(endpoint);
    }

    public NFSeAbstract getSOAP(URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            NFSeAbstractStub _stub = getStub(portAddress, this);
            _stub.setPortName(getSoapServiceName());
            return _stub;
        }
        catch (AxisFault e) {
            return null;
        }
    }


}
