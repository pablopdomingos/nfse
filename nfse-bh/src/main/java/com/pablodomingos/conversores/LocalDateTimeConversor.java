package com.pablodomingos.conversores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class LocalDateTimeConversor implements SingleValueConverter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class classe) {
		return classe.equals(LocalDateTime.class);
	}

	private String getConverted(LocalDateTime source) {
		if (source == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T00:00:00'");
		return format.format(source);
	}

	public String toString(Object obj) {
		return getConverted((LocalDateTime) obj);
	}

	public LocalDateTime fromString(String dateString) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T00:00:00'");
		return LocalDateTime.parse(dateString, format);
	}

}
