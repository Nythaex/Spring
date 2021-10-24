package com.example.exam.model.binding;

import com.example.exam.model.entity.Category;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddShipBinding {
    @Size(min = 2, max = 10)
    private String name;
    @Positive
    @NotNull
    private Long health;
    @Positive
    @NotNull
    private Long power;
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    @Size(min = 4)
    private String category;

    public AddShipBinding(String name, Long health, Long power, LocalDate created, String category) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.created = created;
        this.category = category;
    }

    public AddShipBinding() {
    }

    public String getName() {
        return name;
    }

    public AddShipBinding setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public AddShipBinding setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public AddShipBinding setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddShipBinding setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AddShipBinding setCategory(String category) {
        this.category = category;
        return this;
    }
}
