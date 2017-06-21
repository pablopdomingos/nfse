package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.RpsTipo;
import org.simpleframework.xml.transform.Transform;

public class NFRpsTipoTransformer implements Transform<RpsTipo> {
    @Override
    public RpsTipo read(final String value) throws Exception {
        return RpsTipo.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final RpsTipo value) throws Exception {
        return value.toString();
    }
}