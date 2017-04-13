package com.pablodomingos.webservices.bh;

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

public class StubBH extends NFSeAbstractStub {

  public StubBH(URL endpointURL, Service service) throws AxisFault {
    super(endpointURL, service);
  }

  public Object recepcionarLoteRps(Object... parameters) throws RemoteException {
    Call call = super.createCall();
    OperationDesc operationDesc = new OperationDesc();
    operationDesc.setName("RecepcionarLoteRps");
    ParameterDesc param = new ParameterDesc(new QName("http://ws.bhiss.pbh.gov.br", "RecepcionarLoteRpsRequest"), ParameterDesc.IN, new QName("http://ws.bhiss.pbh.gov.br", "input"), InputBH.class, false, false);
    operationDesc.addParameter(param);
    operationDesc.setReturnType(new QName("http://ws.bhiss.pbh.gov.br", "output"));
    operationDesc.setReturnClass(OutputBH.class);
    operationDesc.setReturnQName(new QName("http://ws.bhiss.pbh.gov.br", "RecepcionarLoteRpsResponse"));
    operationDesc.setStyle(org.apache.axis.constants.Style.DOCUMENT);
    operationDesc.setUse(org.apache.axis.constants.Use.LITERAL);


    call.setOperation(operationDesc);
    call.setSOAPActionURI("http://ws.bhiss.pbh.gov.br/RecepcionarLoteRps");
    _call.setOperationName(new QName("", "RecepcionarLoteRps"));
    return genericCall(call, parameters);
  }

  public Object consultarLoteRps(Object... parameters) throws RemoteException {
    Call call = super.createCall();

    OperationDesc operationDesc = new OperationDesc();
    operationDesc.setName("ConsultarLoteRps");
    ParameterDesc param = new ParameterDesc(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsRequest"), ParameterDesc.IN, new QName("http://ws.bhiss.pbh.gov.br", "input"), InputBH.class, false, false);
    operationDesc.addParameter(param);
    operationDesc.setReturnType(new QName("http://ws.bhiss.pbh.gov.br", "output"));
    operationDesc.setReturnClass(OutputBH.class);
    operationDesc.setReturnQName(new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsResponse"));
    operationDesc.setStyle(Style.DOCUMENT);
    operationDesc.setUse(Use.LITERAL);

    call.setOperation(operationDesc);
    call.setSOAPActionURI("http://ws.bhiss.pbh.gov.br/GerarNfse");
    _call.setOperationName(new QName("", "GerarNfse"));
    return genericCall(call, parameters);
  }

  public Object gerarNfse(Object... parameters) throws RemoteException {
    Call call = super.createCall();

    OperationDesc operationDesc = new OperationDesc();
    operationDesc.setName("GerarNfse");
    ParameterDesc param = new ParameterDesc(new QName("http://ws.bhiss.pbh.gov.br", "GerarNfseRequest"), ParameterDesc.IN, new QName("http://ws.bhiss.pbh.gov.br", "input"), InputBH.class, false, false);
    operationDesc.addParameter(param);
    operationDesc.setReturnType(new QName("http://ws.bhiss.pbh.gov.br", "output"));
    operationDesc.setReturnClass(OutputBH.class);
    operationDesc.setReturnQName(new QName("http://ws.bhiss.pbh.gov.br", "GerarNfseResponse"));
    operationDesc.setStyle(org.apache.axis.constants.Style.DOCUMENT);
    operationDesc.setUse(org.apache.axis.constants.Use.LITERAL);

    call.setOperation(operationDesc);
    call.setSOAPActionURI("http://ws.bhiss.pbh.gov.br/GerarNfse");
    _call.setOperationName(new QName("", "GerarNfse"));
    return genericCall(call, parameters);
  }
}
