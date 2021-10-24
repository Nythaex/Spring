package com.example.exa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Seller extends BasicEntity{

    @Column(nullable = false)
    @Size(min = 2)
    private String firstName;
    @Column(nullable = false)
    @Size(min = 2)
    private String lastName;
    @Min(18)
    @Column(nullable = false)
    private Integer age;
    @Positive
    @Column(nullable = false)
    private BigDecimal salary;
    @ManyToOne
    private Shop shop;
    @ManyToOne
    private Seller manager;
    @OneToMany (mappedBy = "manager")
    private List<Seller> sellers;

    public Seller(String firstName, String lastName, Integer age, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    public Seller() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
