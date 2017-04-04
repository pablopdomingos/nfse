package com.pablodomingos.classes.rps.servicos;

import com.thoughtworks.xstream.XStream;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class AbstractService {

  protected boolean addHeader() {
    return true;
  }

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public String converterParaXml() {
    String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);

    Set<ConstraintViolation<Object>> violations = validator.validate(this);
    if (!violations.isEmpty()) {
      Set<String> violationMessages = new HashSet<>();
      for (ConstraintViolation<Object> constraintViolation : violations) {
        violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
      }
      throw new ConstraintViolationException(violationMessages.toString() , violations);
    }
    String xml = xstream.toXML(this);
    if (addHeader()) {
      xml = XML_HEADER + xml;
    }
    return xml;
  }
  
}
