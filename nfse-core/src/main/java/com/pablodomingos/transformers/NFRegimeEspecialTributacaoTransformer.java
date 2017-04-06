package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import org.simpleframework.xml.transform.Transform;

public class NFRegimeEspecialTributacaoTransformer implements Transform<RegimeEspecialTributacao> {
    @Override
    public RegimeEspecialTributacao read(final String value) throws Exception {
        return RegimeEspecialTributacao.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final RegimeEspecialTributacao value) throws Exception {
        return value.toString();
    }
}