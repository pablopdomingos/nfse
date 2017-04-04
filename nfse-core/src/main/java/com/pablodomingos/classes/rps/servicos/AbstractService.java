package com.pablodomingos.classes.rps.servicos;

import com.thoughtworks.xstream.XStream;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractService {

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

//    return XML_HEADER + xstream.toXML(this);
    return xstream.toXML(this);
  }
  
}
