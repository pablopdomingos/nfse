package com.pablodomingos.classes;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class XmlFake {
  public static String get(String path) {
    String xml = null;
    try {
      FileInputStream inputStream = new FileInputStream(path);
      if (inputStream == null)
        return null;
      xml = IOUtils.toString(inputStream);
    } catch (IOException e) {
    }
    return xml;
  }
}
