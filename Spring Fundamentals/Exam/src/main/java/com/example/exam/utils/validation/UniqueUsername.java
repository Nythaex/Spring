package com.example.exam.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidatorUsername.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Contains in Database";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
