package com.pablodomingos.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFLocalDateTimeTransformer implements Transform<LocalDateTime> {
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime read(final String time) throws Exception {
        return LocalDateTime.parse(time, DATETIME_FORMATTER);
    }

    @Override
    public String write(final LocalDateTime localTime) throws Exception {
        return DATETIME_FORMATTER.format(localTime);
    }
}