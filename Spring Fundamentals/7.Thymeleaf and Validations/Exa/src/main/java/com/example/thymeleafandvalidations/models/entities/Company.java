package com.example.thymeleafandvalidations.models.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Company extends BasicEntity{
    private BigDecimal budget;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(unique = true)
    private String name;
    private String town;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    public Company(BigDecimal  budget, String description, String name, String town) {
        this.budget = budget;
        this.description = description;
        this.name = name;
        this.town = town;
    }

    public Company() {
    }

    public BigDecimal  getBudget() {
        return budget;
    }

    public Company setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Company setTown(String town) {
        this.town = town;
        return this;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Company setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
