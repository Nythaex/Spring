package com.example.exa.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Town extends BasicEntity{

    private String name;
    @OneToMany(mappedBy = "town")
    private List<Shop> shops;

    public Town( String name) {

        this.name = name;
    }

    public Town() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
