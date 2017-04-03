package com.pablodomingos.webservices.bhiss;

import com.pablodomingos.webservices.core.NFSeAbstractStub;
import org.apache.axis.AxisFault;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import java.net.URL;

public class StubBHISS extends NFSeAbstractStub<Output> {

    public StubBHISS(URL endpointURL, Service service) throws AxisFault {
        super(endpointURL, service);
    }

    @Override
    public OperationDesc consultarLoteRpsOperation() {
        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("ConsultarLoteRps");
        ParameterDesc param = new ParameterDesc(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsRequest"), ParameterDesc.IN, new QName("http://ws.bhiss.pbh.gov.br", "input"), Input.class, false, false);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://ws.bhiss.pbh.gov.br", "output"));
        operationDesc.setReturnClass(Output.class);
        operationDesc.setReturnQName(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsResponse"));
        operationDesc.setStyle(Style.DOCUMENT);
        operationDesc.setUse(Use.LITERAL);
        return operationDesc;
    }

    @Override
    public OperationDesc gerarNfseOperation() {
        OperationDesc oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GerarNfse");
        ParameterDesc param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "GerarNfseRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "input"), Input.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "output"));
        oper.setReturnClass(Output.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "GerarNfseResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        return oper;
//        OperationDesc operationDesc = new OperationDesc();
//        operationDesc.setName("GerarNfse");
//        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
//        param.setOmittable(true);
//        operationDesc.addParameter(param);
//        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
//        param.setOmittable(true);
//        operationDesc.addParameter(param);
//        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
//        operationDesc.setReturnClass(String.class);
//        operationDesc.setReturnQName(new QName("", "return"));
//        operationDesc.setStyle(Style.WRAPPED);
//        operationDesc.setUse(Use.LITERAL);
//        return operationDesc;
    }
}
