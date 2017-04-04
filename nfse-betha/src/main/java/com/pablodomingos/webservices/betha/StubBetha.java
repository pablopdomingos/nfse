package com.pablodomingos.webservices.betha;

import com.pablodomingos.webservices.core.NFSeAbstractStub;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import java.net.URL;
import java.rmi.RemoteException;

public class StubBetha extends NFSeAbstractStub<Output> {

    public StubBetha(URL endpointURL, Service service) throws AxisFault {
        super(endpointURL, service);
    }

    @Override
    public Call consultarLoteRpsCall() throws RemoteException {
        Call call = super.consultarLoteRpsCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("ConsultarLoteRps");
        ParameterDesc param = new ParameterDesc(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsRequest"), ParameterDesc.IN, new QName("http://ws.bhiss.pbh.gov.br", "input"), Input.class, false, false);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://ws.bhiss.pbh.gov.br", "output"));
        operationDesc.setReturnClass(Output.class);
        operationDesc.setReturnQName(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsResponse"));
        operationDesc.setStyle(Style.DOCUMENT);
        operationDesc.setUse(Use.LITERAL);
        
        call.setOperation(operationDesc);
        call.setSOAPActionURI("http://ws.bhiss.pbh.gov.br/GerarNfse");
        _call.setOperationName(new QName("", "GerarNfse"));
        return call;
    }

    @Override
    public Call gerarNfseCall() throws RemoteException {
        Call call = super.gerarNfseCall();

        OperationDesc operationDesc = new org.apache.axis.description.OperationDesc();
        operationDesc.setName("GerarNfse");
        ParameterDesc param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nfseCabecMsg"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nfseDadosMsg"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(java.lang.String.class);
        operationDesc.setReturnQName(new javax.xml.namespace.QName("", "return"));
        operationDesc.setStyle(org.apache.axis.constants.Style.WRAPPED);
        operationDesc.setUse(org.apache.axis.constants.Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("GerarNfseEnvio");
        call.setOperationName(new javax.xml.namespace.QName("http://www.betha.com.br/e-nota-contribuinte-ws", "GerarNfse"));
        return call;
    }
}
