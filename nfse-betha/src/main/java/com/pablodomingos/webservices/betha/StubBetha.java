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

public class StubBetha extends NFSeAbstractStub {

    public StubBetha(URL endpointURL, Service service) throws AxisFault {
        super(endpointURL, service);
    }

    public Object cancelarNfse(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("CancelarNfse");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("CancelarNfseEnvio");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "CancelarNfse"));
        return genericCall(call, parameters);
    }
    public Object consultarLoteRps(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("ConsultarLoteRps");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("ConsultarLoteRpsEnvio");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "ConsultarLoteRps"));
        return genericCall(call, parameters);
    }
//    public Object consultarNfseFaixa(Object... parameters) throws RemoteException {
//        return genericCall(consultarNfseFaixaCall(), parameters);
//    }
//    public Object consultarNfsePorRps(Object... parameters) throws RemoteException {
//        return genericCall(consultarNfsePorRpsCall(), parameters);
//    }
    public Object consultarNfseServicoPrestado(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("ConsultarNfseServicoPrestado");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("ConsultarNfseServicoPrestadoEnvio");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "ConsultarNfseServicoPrestado"));
        return genericCall(call, parameters);
    }

    public Object consultarNfseServicoTomado(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("ConsultarNfseServicoTomado");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("ConsultarNfseServicoTomadoEnvio");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "ConsultarNfseServicoTomado"));
        return genericCall(call, parameters);
    }
//    public Object consultarSituacaoLoteRps(Object... parameters) throws RemoteException {
//        return genericCall(consultarSituacaoLoteRpsCall(), parameters);
//    }
    public Object gerarNfse(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("GerarNfse");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("GerarNfseEnvio");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "GerarNfse"));
        return genericCall(call, parameters);
    }
    public Object recepcionarLoteRps(Object... parameters) throws RemoteException {
        Call call = super.createCall();

        OperationDesc operationDesc = new OperationDesc();
        operationDesc.setName("RecepcionarLoteRps");
        ParameterDesc param = new ParameterDesc(new QName("", "nfseCabecMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        param = new ParameterDesc(new QName("", "nfseDadosMsg"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        operationDesc.addParameter(param);
        operationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        operationDesc.setReturnClass(String.class);
        operationDesc.setReturnQName(new QName("", "return"));
        operationDesc.setStyle(Style.WRAPPED);
        operationDesc.setUse(Use.LITERAL);

        call.setOperation(operationDesc);
        call.setSOAPActionURI("RecepcionarLoteRps");
        call.setOperationName(new QName("http://www.betha.com.br/e-nota-contribuinte-ws", "RecepcionarLoteRps"));
        return genericCall(call, parameters);
    }
//    public Object recepcionarLoteRpsSincrono(Object... parameters) throws RemoteException {
//        return genericCall(recepcionarLoteRpsSincronoCall(), parameters);
//    }
//    public Object substituirNfse(Object... parameters) throws RemoteException {
//        return genericCall(substituirNfseCall(), parameters);
//    }
}
