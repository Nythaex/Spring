package com.example.exam.model.view;

import javax.persistence.Column;

public class ViewShip {

    private Long id;
    private String name;

    private Long health;

    private Long power;

    public ViewShip(Long id,String name, Long health, Long power) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.id=id;
    }

    public ViewShip() {
    }

    public Long getId() {
        return id;
    }

    public ViewShip setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ViewShip setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ViewShip setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ViewShip setPower(Long power) {
        this.power = power;
        return this;
    }
}
