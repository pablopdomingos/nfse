package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.ExigibilidadeIss;
import org.simpleframework.xml.transform.Transform;

public class NFExigibilidadeIssTransformer implements Transform<ExigibilidadeIss> {
    @Override
    public ExigibilidadeIss read(final String value) throws Exception {
        return ExigibilidadeIss.fromInt(Integer.valueOf(value));
    }

    @Override
    public String write(final ExigibilidadeIss value) throws Exception {
        return value.toString();
    }
}