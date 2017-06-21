package com.pablodomingos.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class NFLocalDateTransformer implements Transform<LocalDate> {
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate read(final String data) throws Exception {
        return LocalDate.parse(data, DATETIME_FORMATTER);
    }

    @Override
    public String write(final LocalDate data) throws Exception {
        return NFLocalDateTransformer.DATETIME_FORMATTER.format(data);
    }
}