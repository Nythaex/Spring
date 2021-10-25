package com.example.demo.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Town extends BasicEntity{
    @Column(unique = true,nullable = false)
    private String name;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "town")
    private Set<Shelter> shelters;

    public Town() {
    }

    public Town(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }


    public Set<Shelter> getShelters() {
        return shelters;
    }

    public Town setShelters(Set<Shelter> shelters) {
        this.shelters = shelters;
        return this;
    }
}
