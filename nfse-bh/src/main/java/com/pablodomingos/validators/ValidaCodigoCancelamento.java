package com.pablodomingos.validators;


import com.pablodomingos.classes.rps.enums.CodigoCancelamento;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ValidaCodigoCancelamento implements ConstraintValidator<ValidaCodigoCancelamento.Validate, CodigoCancelamento> {

  @Target({ElementType.FIELD})
  @Retention(RetentionPolicy.RUNTIME)
  @Constraint(validatedBy = ValidaCodigoCancelamento.class)
  public @interface Validate {
    String message() default "O padrão BHISS não aceita cancelamento por ERRO_NA_EMISSAO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }

  private Validate validate;

  @Override
  public void initialize(Validate validate) {
    this.validate = validate;
  }

  @Override
  public boolean isValid(CodigoCancelamento codigoCancelamento, ConstraintValidatorContext constraintContext) {
    if (codigoCancelamento != null && codigoCancelamento.equals(CodigoCancelamento.ERRO_NA_EMISSAO)) {
      return false;
    }
    return true;
  }
}
