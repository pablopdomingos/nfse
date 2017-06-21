package com.pablodomingos.webservices.core;

public interface NFSeCallbackHandler<T> {
    void callback(T... object);
}
