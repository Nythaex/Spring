package com.example.thymeleafandvalidations.models.service;

import com.example.thymeleafandvalidations.models.entities.Company;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddEmployeeServiceModel {

    private LocalDate birthdate;

    private String educationLevel;


    private String firstName;

    private String jobTitle;

    private String lastName;

    private BigDecimal salary;
    private Company company;

    public AddEmployeeServiceModel(LocalDate birthdate, String educationLevel, String firstName, String jobTitle, String lastName, BigDecimal salary) {
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.lastName = lastName;
        this.salary = salary;
    }

    public AddEmployeeServiceModel() {
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AddEmployeeServiceModel setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public AddEmployeeServiceModel setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AddEmployeeServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public AddEmployeeServiceModel setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddEmployeeServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public AddEmployeeServiceModel setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public AddEmployeeServiceModel setCompany(Company company) {
        this.company = company;
        return this;
    }
}
