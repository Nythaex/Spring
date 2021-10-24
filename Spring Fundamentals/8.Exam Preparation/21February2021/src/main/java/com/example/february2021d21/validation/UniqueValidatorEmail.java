package com.example.february2021d21.validation;

import com.example.february2021d21.service.UserService;

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
