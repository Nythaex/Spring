package com.example.lab.models.entity;

import com.example.lab.models.entity.Enums.Engine;
import com.example.lab.models.entity.Enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;

import java.time.LocalDateTime;


@Entity
@Table(name = "offers")
public class Offer extends BasicEntity {
    @Column(columnDefinition = "TEXT")
    private String description;

    private Engine engine;

    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;

    private Transmission transmission;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Models model;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User seller;

    public Offer() {
    }

    public Offer(String description, Engine engine, String imageUrl, Integer mileage, BigDecimal price, Transmission transmission, Integer year, LocalDateTime created, LocalDateTime modified, Models model, User seller) {
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
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
