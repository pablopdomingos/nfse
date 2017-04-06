package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.IncentivadorCultural;
import org.simpleframework.xml.transform.Transform;

public class NFIncentivadorCulturalTransformer implements Transform<IncentivadorCultural> {
    @Override
    public IncentivadorCultural read(final String value) throws Exception {
        return IncentivadorCultural.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final IncentivadorCultural value) throws Exception {
        return value.toString();
    }
}