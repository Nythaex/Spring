package com.example.thymeleafandvalidations.models.binding;

import com.example.thymeleafandvalidations.models.entities.Company;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddEmployeeBinding {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @NotNull
    private String educationLevel ;
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    private String jobTitle;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @NotNull
    @Positive
    private BigDecimal salary;
    @NotNull
    private String company;

    public AddEmployeeBinding(LocalDate birthdate, String educationLevel, String firstName, String jobTitle, String lastName, BigDecimal salary, String company) {
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
    }

    public AddEmployeeBinding() {
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AddEmployeeBinding setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public AddEmployeeBinding setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AddEmployeeBinding setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public AddEmployeeBinding setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddEmployeeBinding setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public AddEmployeeBinding setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public AddEmployeeBinding setCompany(String company) {
        this.company = company;
        return this;
    }
}
