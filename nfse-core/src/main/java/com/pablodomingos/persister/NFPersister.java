package com.pablodomingos.persister;

import com.pablodomingos.transformers.NFRegistryMatcher;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

public class NFPersister extends Persister {
    public NFPersister() {
        super(new AnnotationStrategy(), new NFRegistryMatcher(), new Format(2));
    }
}
