package com.pablodomingos.webservices.core;

import com.pablodomingos.persister.NFPersister;
import org.simpleframework.xml.Serializer;

import java.io.StringReader;

public class NFSeAbstractWebService {
  public static <T>T fromXml(Class<? extends T> clazz, Object xml) throws Exception {
    return NFSeAbstractWebService.fromXml(clazz, xml.toString());
  }
  public static <T>T fromXml(Class<? extends T> clazz, String xml) throws Exception {
    Serializer serializer = new NFPersister();
    System.out.println(xml);
    return serializer.read(clazz, new StringReader(xml));
  }
}
