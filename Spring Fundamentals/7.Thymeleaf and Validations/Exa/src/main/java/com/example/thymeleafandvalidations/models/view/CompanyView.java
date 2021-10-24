package com.example.thymeleafandvalidations.models.view;

import java.math.BigDecimal;

public class CompanyView {
    private Long id;
    private String description;
    private String town;
    private String name;
    private BigDecimal budget;

    public CompanyView(Long id,String description, String town, String name,BigDecimal budget) {
        this.description = description;
        this.town = town;
        this.name = name;
        this.id=id;
        this.budget=budget;
    }

    public CompanyView() {
    }

    public Long getId() {
        return id;
    }

    public CompanyView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyView setTown(String town) {
        this.town = town;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public CompanyView setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
