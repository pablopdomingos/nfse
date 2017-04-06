package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.OptanteSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFOptanteSimplesNacionalTransformer implements Transform<OptanteSimplesNacional> {
    @Override
    public OptanteSimplesNacional read(final String value) throws Exception {
        return OptanteSimplesNacional.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final OptanteSimplesNacional value) throws Exception {
        return value.toString();
    }
}