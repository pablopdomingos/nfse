package com.pablodomingos.classes.rps.enums;

public enum RpsSerie {
  NFE, A;

  public static RpsSerie fromString(String value) {
    for (RpsSerie rpsSerie : RpsSerie.values()) {
      if (rpsSerie.name().toUpperCase().equals(value)) {
        return rpsSerie;
      }
    }
    return RpsSerie.A;
  }
}
