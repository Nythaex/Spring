package com.example.thymeleafandvalidations.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Contains in Database";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
