package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import org.simpleframework.xml.transform.Transform;

public class NFLoteRpsVersaoTransformer implements Transform<LoteRpsVersao> {
    @Override
    public LoteRpsVersao read(final String value) throws Exception {
        return LoteRpsVersao.fromVersao(value);
    }

    @Override
    public String write(final LoteRpsVersao value) throws Exception {
        return value.toString();
    }
}