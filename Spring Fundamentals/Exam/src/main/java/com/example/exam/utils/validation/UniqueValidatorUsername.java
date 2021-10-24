package com.example.exam.utils.validation;

import com.example.exam.service.UserService;



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
