package com.pablodomingos.webservices.core;

import com.pablodomingos.config.CertificadoConfig;
import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.encoding.ser.*;
import org.apache.axis.soap.SOAPConstants;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.SerializerFactory;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Vector;

public abstract class NFSeAbstractStub<T> extends Stub implements NFSeAbstract<T> {
    private Vector cachedSerClasses = new Vector();
    private Vector cachedSerQNames = new Vector();
    private Vector cachedSerFactories = new Vector();
    private Vector cachedDeserFactories = new Vector();
    private CertificadoConfig certificadoConfig;

    protected Call gerarNfseCall() throws RemoteException {
        return createCall();
    }
    protected Call consultarLoteRpsCall() throws RemoteException {
        return createCall();
    }



    public NFSeAbstractStub(URL endpointURL, Service service) throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public NFSeAbstractStub(Service service) throws org.apache.axis.AxisFault { //fixme
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
        Class cls;
        javax.xml.namespace.QName qName;
        javax.xml.namespace.QName qName2;
        Class beansf = BeanSerializerFactory.class;
        Class beandf = BeanDeserializerFactory.class;
        Class enumsf = EnumSerializerFactory.class;
        Class enumdf = EnumDeserializerFactory.class;
        Class arraysf = ArraySerializerFactory.class;
        Class arraydf = ArrayDeserializerFactory.class;
        Class simplesf = SimpleSerializerFactory.class;
        Class simpledf = SimpleDeserializerFactory.class;
        Class simplelistsf = SimpleListSerializerFactory.class;
        Class simplelistdf = SimpleListDeserializerFactory.class;
//        qName = new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "input");
//        cachedSerQNames.add(qName);
//        cls = com.pablodomingos.webservices.pbh.Input.class;
//        cachedSerClasses.add(cls);
//        cachedSerFactories.add(beansf);
//        cachedDeserFactories.add(beandf);
//
//        qName = new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "output");
//        cachedSerQNames.add(qName);
//        cls = Output.class;
//        cachedSerClasses.add(cls);
//        cachedSerFactories.add(beansf);
//        cachedDeserFactories.add(beandf);

    }

    private T genericCall(Call _call, Object... parameters) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(parameters);
            if (_resp instanceof RemoteException) {
                throw (RemoteException) _resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (T)_resp;
                } catch (Exception _exception) {
                    System.out.println("ERRR2 = " + _exception.getMessage());
                    _exception.printStackTrace(); //fixme
//                    callback.callback(JavaUtils.convert(_resp, T.class));
//                    return (Output) org.apache.axis.utils.JavaUtils.convert(_resp, Output.class);
                }
            }
        } catch (AxisFault axisFaultException) {
            System.out.println("ERRR = " + axisFaultException.getMessage());
            throw axisFaultException;
        }
        return null;
    }

    public T gerarNfse(Object... parameters) throws RemoteException {
        return genericCall(gerarNfseCall(), parameters);
    }
    
    public T consultarLoteRps(Object... parameters) throws RemoteException {
        return genericCall(consultarLoteRpsCall(), parameters);
    }

    protected Call createCall() throws RemoteException {
        try {
            Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        QName qName = (QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                    cachedSerFactories.get(i);
                            Class df = (Class)
                                    cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                    cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                    cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            _call.setUseSOAPAction(true);
            _call.setEncodingStyle(null);
            _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
            _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            return _call;
        }
        catch (Throwable _t) {
            throw new AxisFault("Failure trying to get the Call object", _t);
        }
    }
}
