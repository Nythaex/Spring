package com.example.thymeleafandvalidations.models.binding;

import com.example.thymeleafandvalidations.validations.Unique;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddCompanyBinding {
    @Positive
    @NotNull
    private BigDecimal budget;
    @Size(min = 10)
    @NotNull
    private String description;
    @Size(min = 2,max = 10)
    @NotNull
    @Unique
    private String name;
    @Size(min = 2,max = 10)
    @NotNull
    private String town;

    public AddCompanyBinding(BigDecimal budget, String description, String name, String town) {
        this.budget = budget;
        this.description = description;
        this.name = name;
        this.town = town;
    }

    public AddCompanyBinding() {
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public AddCompanyBinding setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddCompanyBinding setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddCompanyBinding setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AddCompanyBinding setTown(String town) {
        this.town = town;
        return this;
    }
}
