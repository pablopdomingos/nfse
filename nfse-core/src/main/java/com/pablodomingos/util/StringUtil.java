package com.pablodomingos.util;

import java.text.Normalizer;

public class StringUtil {

  public static String removeAcentos(String str) {
    CharSequence cs = new StringBuilder(str == null ? "" : str);
    return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
}

}
