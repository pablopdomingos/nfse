package com.pablodomingos.webservices.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NFSeAbstract<T> extends Remote {
//    T cancelarNfse(Object... parameters) throws RemoteException;
    T consultarLoteRps(Object... parameters) throws RemoteException;
//    T consultarNfse(Object... parameters) throws RemoteException;
//    T consultarNfsePorFaixa(Object... parameters) throws RemoteException;
//    T consultarNfsePorRps(Object... parameters) throws RemoteException;
//    T consultarSituacaoLoteRps(Object... parameters) throws RemoteException;
//    T recepcionarLoteRps(Object... parameters) throws RemoteException;
    T gerarNfse(Object... parameters) throws RemoteException;
}
