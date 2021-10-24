package com.example.exa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Product extends BasicEntity{

    private LocalDate bestBefore;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    @Size(min = 2)
    private String name;
    @Positive
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToMany
    private List<Shop> shops;
    @ManyToOne
    private Category category;


    public Product(LocalDate bestBefore, String description, String name, BigDecimal price) {
        this.bestBefore = bestBefore;
        this.description = description;
        this.name = name;
        this.price = price;
    }
    public Product() {

    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
