package com.pablodomingos.util;

import com.pablodomingos.persister.NFPersister;
import org.simpleframework.xml.Serializer;

import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtil {
  public static String toXml(Object object) {
    StringWriter writer = new StringWriter();
    Serializer serializer = new NFPersister();
    try {
      serializer.write(object, writer);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return writer.getBuffer().toString();
  }

  public static <T>T fromXml(Class<? extends T> clazz, Object xml) throws Exception {
    return XmlUtil.fromXml(clazz, xml.toString());
  }
  public static <T>T fromXml(Class<? extends T> clazz, String xml) throws Exception {
    Serializer serializer = new NFPersister();
    return serializer.read(clazz, new StringReader(xml));
  }
}
