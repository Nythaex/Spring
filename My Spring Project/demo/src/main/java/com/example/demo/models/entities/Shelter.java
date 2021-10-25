package com.example.demo.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Shelter extends BasicEntity{

    private Boolean isBanned;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Town town;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "shelter")
    private Set<Animal> animals;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "shelter")
    private Set<Worker> workers;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "shelter")
    private Set<Message> messages;

    public Shelter() {
    }

    public Shelter(String username, String password, String email, String phoneNumber, String name, String description, Town town) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.description = description;
        this.town = town;
        this.isBanned=false;
    }

    public String getUsername() {
        return username;
    }

    public Shelter setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Shelter setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Shelter setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Shelter setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shelter setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Shelter setDescription(String description) {
        this.description = description;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Shelter setTown(Town town) {
        this.town = town;
        return this;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public Shelter setAnimals(Set<Animal> animals) {
        this.animals = animals;
        return this;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public Shelter setWorkers(Set<Worker> workers) {
        this.workers = workers;
        return this;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Shelter setMessages(Set<Message> messages) {
        this.messages = messages;
        return this;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public Shelter setBanned(Boolean banned) {
        isBanned = banned;
        return this;
    }
}
