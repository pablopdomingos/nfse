package com.pablodomingos.classes.servicos;

import com.pablodomingos.persister.NFPersister;
import com.pablodomingos.util.XmlUtil;
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
    String xml = XmlUtil.toXml(this);
    if (addHeader()) {
      xml = XML_HEADER + xml;
    }
    return xml;
  }
}
