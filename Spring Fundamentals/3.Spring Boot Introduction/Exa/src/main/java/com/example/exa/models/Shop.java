package com.example.exa.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Shop extends BasicEntity{
    @Size(min = 2)
    @Column(unique = true,nullable = false)
    private String address;
    @Size(min = 2)
    private String name;
    @ManyToOne
    private Town town;
    @OneToMany(mappedBy = "shop")
    private List<Seller> sellers;
    @ManyToMany(mappedBy = "shops")
    private List<Product> products;

    public Shop(String address, String name) {
        this.address = address;
        this.name = name;
    }
    public Shop() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
