package com.example.february2021d21.validation;

import com.example.february2021d21.service.UserService;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidatorUsername implements ConstraintValidator<UniqueUsername,String> {
    private UserService userService;

    public UniqueValidatorUsername(UserService companyService) {
        this.userService = companyService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return  userService.existByUsername(value);
    }
}
