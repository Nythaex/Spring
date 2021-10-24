package com.example.february2021d21.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Artist extends BasicEntity {

    @Column(nullable = false)
    private String name;


    @Column(columnDefinition = "TEXT",nullable = false)
    private String careerInformation;


    public Artist(String name, String careerInformation) {

        this.name = name;
        this.careerInformation = careerInformation;
    }

    public Artist() {

    }

    public String getName() {
        return name;
    }

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
