package com.example.thymeleafandvalidations.models.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee extends BasicEntity{
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate birthdate;
    private String educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    @ManyToOne
    private Company company;

    public Employee(LocalDate birthdate, String educationLevel, String firstName, String jobTitle, String lastName, BigDecimal salary) {
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.lastName = lastName;
        this.salary = salary;

    }

    public Employee() {

    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Employee setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public Employee setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Employee setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Employee setCompany(Company company) {
        this.company = company;
        return this;
    }
}
