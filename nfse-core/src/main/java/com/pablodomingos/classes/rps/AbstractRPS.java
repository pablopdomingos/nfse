package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.AbstractBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class AbstractRPS {
//    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public AbstractRPS() {
//        T object = (T) builder;
//        Set<ConstraintViolation> violations = validator.validate(this);
//        if (!violations.isEmpty()) {
//            Set<String> violationMessages = new HashSet<String>();
//            for (ConstraintViolation constraintViolation : violations) {
//                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
//            }
//            throw new ConstraintViolationException(violationMessages.toString() , violations);
//        }
    }

//    public AbstractRPS(AbstractBuilder builder) {

//        T object = (T) builder;
//        Set<ConstraintViolation<T>> violations = validator.validate(object);
//        if (!violations.isEmpty()) {
//            Set<String> violationMessages = new HashSet<String>();
//            for (ConstraintViolation<T> constraintViolation : violations) {
//                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
//            }
//            throw new ConstraintViolationException(violationMessages.toString() , violations);
//        }
//    }
}