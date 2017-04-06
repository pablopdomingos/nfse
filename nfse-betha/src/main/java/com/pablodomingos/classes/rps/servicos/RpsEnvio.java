package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.rps.Rps;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.validation.Valid;

@Root(name = "GerarNfseEnvio")
public class RpsEnvio extends AbstractServiceBetha {

    @Attribute(name = "xmlns")
    private String xmlns = "http://www.betha.com.br/e-nota-contribuinte-ws";

    @Element(name = "Rps")
    @Valid
    private Rps rps;

    public RpsEnvio(Rps rps) {
        this.rps = rps;
    }

}
