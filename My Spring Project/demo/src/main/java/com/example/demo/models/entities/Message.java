package com.example.demo.models.entities;

import javax.persistence.*;

@Entity
public class Message extends BasicEntity{

    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Shelter shelter;

    public Message() {
    }

    public Message(String title, String description, User user, Shelter shelter) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.shelter = shelter;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Message setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Message setUser(User user) {
        this.user = user;
        return this;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public Message setShelter(Shelter shelter) {
        this.shelter = shelter;
        return this;
    }
}
