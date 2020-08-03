package com.ngsharma.SpringApp.custom.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MobileNumberConstraint.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {
    String message() default "Mobile Number Invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
