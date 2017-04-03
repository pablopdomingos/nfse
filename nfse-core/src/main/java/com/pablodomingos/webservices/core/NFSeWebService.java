/**
 * NfseWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pablodomingos.webservices.core;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface NFSeWebService extends Service {
    String getSOAPAddress();

    NFSeAbstract getSOAP() throws ServiceException;

    NFSeAbstract getSOAP(java.net.URL portAddress) throws ServiceException;
}
