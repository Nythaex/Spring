package com.example.lab.models.view;

import com.example.lab.models.entity.Enums.Engine;
import com.example.lab.models.entity.Enums.Transmission;
import com.example.lab.models.entity.Models;
import com.example.lab.models.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetailsView {

    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;

    private String model;

    private String seller;

    public DetailsView(Long id,String description, Engine engine, String imageUrl, Integer mileage, BigDecimal price,String brand, Transmission transmission, Integer year, LocalDateTime created, LocalDateTime modified, String model, String seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
        this.id=id;
        this.brand=brand;
    }

    public String getBrand() {
        return brand;
    }

    public DetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public DetailsView() {
    }

    public Long getId() {
        return id;
    }

    public DetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public DetailsView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public DetailsView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public DetailsView setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public DetailsView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public DetailsView setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public DetailsView setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModel() {
        return model;
    }

    public DetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public DetailsView setSeller(String seller) {
        this.seller = seller;
        return this;
    }
}
