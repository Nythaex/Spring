package com.example.thymeleafandvalidations.validations;

import com.example.thymeleafandvalidations.services.CompanyService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique,String> {
    private CompanyService companyService;

    public UniqueValidator(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return  companyService.existByUsername(value);
    }
}
