package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.IssRetido;
import org.simpleframework.xml.transform.Transform;

public class NFIssRetidoTransformer implements Transform<IssRetido> {
    @Override
    public IssRetido read(final String value) throws Exception {
        return IssRetido.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final IssRetido value) throws Exception {
        return value.toString();
    }
}