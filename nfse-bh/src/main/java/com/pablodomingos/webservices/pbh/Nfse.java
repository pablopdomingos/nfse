/**
 * Nfse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pablodomingos.webservices.pbh;

public interface Nfse extends java.rmi.Remote {
    public com.pablodomingos.webservices.pbh.Output cancelarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output consultarLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output consultarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output consultarNfsePorFaixa(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output consultarNfsePorRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output consultarSituacaoLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output recepcionarLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
    public com.pablodomingos.webservices.pbh.Output gerarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException;
}
