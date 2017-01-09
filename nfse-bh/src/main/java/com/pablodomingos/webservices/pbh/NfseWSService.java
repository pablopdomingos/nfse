/**
 * NfseWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pablodomingos.webservices.pbh;

public interface NfseWSService extends javax.xml.rpc.Service {
    public java.lang.String getnfseSOAPAddress();

    public com.pablodomingos.webservices.pbh.Nfse getnfseSOAP() throws javax.xml.rpc.ServiceException;

    public com.pablodomingos.webservices.pbh.Nfse getnfseSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
