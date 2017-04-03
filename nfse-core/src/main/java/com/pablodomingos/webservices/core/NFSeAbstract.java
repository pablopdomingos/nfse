package com.pablodomingos.webservices.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NFSeAbstract<T> extends Remote {
    T consultarLoteRps(Object... parameters) throws RemoteException;
    T gerarNfse(Object... parameters) throws RemoteException;
}
