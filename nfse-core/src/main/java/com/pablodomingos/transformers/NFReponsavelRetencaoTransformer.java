package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.ResponsavelRetencao;
import org.simpleframework.xml.transform.Transform;

public class NFReponsavelRetencaoTransformer implements Transform<ResponsavelRetencao> {
    @Override
    public ResponsavelRetencao read(final String value) throws Exception {
        return ResponsavelRetencao.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final ResponsavelRetencao value) throws Exception {
        return value.toString();
    }
}