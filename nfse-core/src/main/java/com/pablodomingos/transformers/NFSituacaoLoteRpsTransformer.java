package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.SituacaoLoteRps;
import org.simpleframework.xml.transform.Transform;

public class NFSituacaoLoteRpsTransformer implements Transform<SituacaoLoteRps> {
    @Override
    public SituacaoLoteRps read(final String value) throws Exception {
        return SituacaoLoteRps.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final SituacaoLoteRps value) throws Exception {
        return String.valueOf(value.getCodigo());
    }
}