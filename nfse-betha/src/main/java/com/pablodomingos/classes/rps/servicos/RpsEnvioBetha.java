package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.RpsBetha;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name = "GerarNfseEnvio")
public class RpsEnvioBetha extends AbstractServiceBetha {

    @Attribute(name = "xmlns")
    private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

    @Element(name = "RpsBetha")
    @Valid
    private RpsBetha rps;

    public RpsEnvioBetha(RpsBetha rps) {
        this.rps = rps;
    }

}
