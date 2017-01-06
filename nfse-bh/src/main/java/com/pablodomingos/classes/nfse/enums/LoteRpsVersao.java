package com.pablodomingos.classes.nfse.enums;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

@XStreamConverter(EnumToStringConverter.class)
public enum LoteRpsVersao {
	
  V1_00{
    @Override
    public String toString() {
      return "1.00";
    }
  }, 
  V2_00{
    @Override
    public String toString() {
      return "2.00";
    }
  }, 
  V2_01{
    @Override
    public String toString() {
      return "2.01";
    }
  }, 
  V2_02{
    @Override
    public String toString() {
      return "2.02";
    }
  }, 
  V2_03{
    @Override
    public String toString() {
      return "2.03";
    }
  };
}