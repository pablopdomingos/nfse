package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.persister.NFPersister;
import org.simpleframework.xml.Serializer;

import javax.validation.Validation;
import javax.validation.Validator;
import java.io.StringWriter;

public abstract class AbstractService {
  protected final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
  protected boolean addHeader() {
    return true;
  }

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public String converterParaXml() {
    StringWriter writer = new StringWriter();
    Serializer serializer = new NFPersister();
    try {
      serializer.write(this, writer);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String xml = writer.getBuffer().toString();
    if (addHeader()) {
      xml = XML_HEADER + xml;
    }
    return xml;
  }
}
