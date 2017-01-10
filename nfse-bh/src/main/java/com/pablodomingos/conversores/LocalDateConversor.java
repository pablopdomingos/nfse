package com.pablodomingos.conversores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class LocalDateConversor implements SingleValueConverter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class classe) {
		return classe.equals(LocalDate.class);
	}

	private String getConverted(LocalDate source) {
		if (source == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return format.format(source);
	}

	public String toString(Object obj) {
		return getConverted((LocalDate) obj);
	}

	public LocalDate fromString(String dateString) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(dateString, format);
	}

}
