package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import org.simpleframework.xml.transform.Transform;

public class NFSeAmbienteTransformer implements Transform<NFSeAmbiente> {
    @Override
    public NFSeAmbiente read(final String value) throws Exception {
        return NFSeAmbiente.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final NFSeAmbiente value) throws Exception {
        return value.toString();
    }
}