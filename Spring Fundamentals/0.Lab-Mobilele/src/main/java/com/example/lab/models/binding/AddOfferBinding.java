package com.example.lab.models.binding;

import com.example.lab.models.entity.Enums.Engine;
import com.example.lab.models.entity.Enums.Transmission;
import com.example.lab.models.entity.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOfferBinding {
    @NotBlank
    @Size(min = 1)
    private String description;
    @NotBlank
    @Size(min = 1)
    private String engine;
    @NotBlank
    @Size(min = 1)
    private String imageUrl;
    @Positive
    private Integer mileage;
    @Positive
    private BigDecimal price;
    @NotBlank
    @Size(min = 1)

    @NotBlank
    @Size(min = 1)
    private String transmission;
    @Positive
    private Integer year;

    @Size(min = 1)
    @NotBlank
    private String model;

    public AddOfferBinding(String description, String engine, String imageUrl, Integer mileage, BigDecimal price, String transmission, Integer year, String model) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
    }

    public AddOfferBinding() {
    }

    public String getDescription() {
        return description;
    }

    public AddOfferBinding setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public AddOfferBinding setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferBinding setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferBinding setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferBinding setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public AddOfferBinding setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferBinding setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddOfferBinding setModel(String model) {
        this.model = model;
        return this;
    }
}
