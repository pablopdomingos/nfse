package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.UfEstados;
import org.simpleframework.xml.transform.Transform;

public class NFUfEstadosTransformer implements Transform<UfEstados> {
    @Override
    public UfEstados read(final String value) throws Exception {
        return UfEstados.fromUf(value);
    }

    @Override
    public String write(final UfEstados value) throws Exception {
        return value.toString();
    }
}