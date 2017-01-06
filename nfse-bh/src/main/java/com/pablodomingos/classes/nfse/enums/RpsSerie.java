package com.pablodomingos.classes.nfse.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum RpsSerie {

  NFE, A;

}
