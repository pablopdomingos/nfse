package com.pablodomingos.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleUtil {
  
  public static Double arredondarDuasCasas(Double valor){
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat df = new DecimalFormat("###.##", symbols);
    df.setRoundingMode(RoundingMode.HALF_EVEN);
    return Double.valueOf(df.format(valor));
  }
  
}
