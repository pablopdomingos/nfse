package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.RpsStatus;
import org.simpleframework.xml.transform.Transform;

public class NFRpsStatusTransformer implements Transform<RpsStatus> {
    @Override
    public RpsStatus read(final String value) throws Exception {
        return RpsStatus.valueOfCodigo(Integer.valueOf(value));
    }

    @Override
    public String write(final RpsStatus value) throws Exception {
        return value.toString();
    }
}