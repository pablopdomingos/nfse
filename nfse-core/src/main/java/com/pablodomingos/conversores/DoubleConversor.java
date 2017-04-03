package com.pablodomingos.conversores;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleConversor extends com.thoughtworks.xstream.converters.basic.DoubleConverter {

  public String toString(Object obj){
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ROOT);
    symbols.setDecimalSeparator('.');
    symbols.setGroupingSeparator(','); 
    
    DecimalFormat formatDecimal = new DecimalFormat("#0.00", symbols);
    formatDecimal.setRoundingMode(RoundingMode.HALF_UP);
    return formatDecimal.format((Double) obj);
  }

}
