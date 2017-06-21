package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import org.simpleframework.xml.transform.Transform;

public class NFCodigoCancelamentoTransformer implements Transform<CodigoCancelamento> {
    @Override
    public CodigoCancelamento read(final String value) throws Exception {
        return CodigoCancelamento.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final CodigoCancelamento value) throws Exception {
        return value.toString();
    }
}