package com.pablodomingos.webservices.pbh;

public class NfseProxy implements com.pablodomingos.webservices.pbh.Nfse {
  private String _endpoint = null;
  private com.pablodomingos.webservices.pbh.Nfse nfse = null;
  
  public NfseProxy() {
    _initNfseProxy();
  }
  
  public NfseProxy(String endpoint) {
    _endpoint = endpoint;
    _initNfseProxy();
  }
  
  private void _initNfseProxy() {
    try {
      nfse = (new com.pablodomingos.webservices.pbh.NfseWSServiceLocator()).getnfseSOAP();
      if (nfse != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)nfse)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)nfse)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (nfse != null)
      ((javax.xml.rpc.Stub)nfse)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.pablodomingos.webservices.pbh.Nfse getNfse() {
    if (nfse == null)
      _initNfseProxy();
    return nfse;
  }
  
  public com.pablodomingos.webservices.pbh.Output cancelarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.cancelarNfse(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output consultarLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.consultarLoteRps(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output consultarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.consultarNfse(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output consultarNfsePorFaixa(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.consultarNfsePorFaixa(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output consultarNfsePorRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.consultarNfsePorRps(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output consultarSituacaoLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.consultarSituacaoLoteRps(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output recepcionarLoteRps(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.recepcionarLoteRps(parameters);
  }
  
  public com.pablodomingos.webservices.pbh.Output gerarNfse(com.pablodomingos.webservices.pbh.Input parameters) throws java.rmi.RemoteException{
    if (nfse == null)
      _initNfseProxy();
    return nfse.gerarNfse(parameters);
  }
  
  
}