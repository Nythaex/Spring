package com.example.thymeleafandvalidations.models.service;

import com.example.thymeleafandvalidations.models.binding.AddCompanyBinding;

import java.math.BigDecimal;

public class AddCompanyServiceModel {
    private BigDecimal budget;
    private String description;
    private String name;
    private String town;

    public AddCompanyServiceModel(BigDecimal budget, String description, String name, String town) {
        this.budget = budget;
        this.description = description;
        this.name = name;
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public AddCompanyServiceModel setTown(String town) {
        this.town = town;
        return this;
    }

    public AddCompanyServiceModel() {
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public AddCompanyServiceModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddCompanyServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddCompanyServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
