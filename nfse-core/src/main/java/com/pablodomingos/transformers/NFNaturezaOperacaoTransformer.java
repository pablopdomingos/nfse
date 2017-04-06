package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import org.simpleframework.xml.transform.Transform;

public class NFNaturezaOperacaoTransformer implements Transform<NaturezaOperacao> {
    @Override
    public NaturezaOperacao read(final String value) throws Exception {
        return NaturezaOperacao.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final NaturezaOperacao value) throws Exception {
        return value.toString();
    }
}