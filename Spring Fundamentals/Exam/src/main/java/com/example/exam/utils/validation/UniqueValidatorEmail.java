package com.example.exam.utils.validation;



import com.example.exam.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidatorEmail implements ConstraintValidator<UniqueEmail,String> {
    private UserService userService;

    public UniqueValidatorEmail(UserService companyService) {
        this.userService = companyService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  userService.existByEmail(value);
    }
}
