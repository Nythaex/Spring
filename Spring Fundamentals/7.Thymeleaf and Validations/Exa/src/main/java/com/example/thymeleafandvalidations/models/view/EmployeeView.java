package com.example.thymeleafandvalidations.models.view;

import com.example.thymeleafandvalidations.models.entities.Company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeView {
    private Long id;
    private LocalDate birthdate;
    private String educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    private String company;

    public EmployeeView(Long id,LocalDate birthdate, String educationLevel, String firstName, String jobTitle, String lastName, BigDecimal salary, String company) {
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
        this.id=id;
    }

    public EmployeeView() {
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Long getId() {
        return id;
    }

    public EmployeeView setId(Long id) {
        this.id = id;
        return this;
    }

    public EmployeeView setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public EmployeeView setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeView setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeView setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeView setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public EmployeeView setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public EmployeeView setCompany(String company) {
        this.company = company;
        return this;
    }
}
