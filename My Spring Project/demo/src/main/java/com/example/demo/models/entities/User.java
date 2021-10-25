package com.example.demo.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BasicEntity{

    private Boolean isAdmin;

    private Boolean isBanned;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;



    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isBanned=false;
        this.isAdmin=false;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public User setAdmin(Boolean admin) {
        isAdmin = admin;
        return this;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public User setBanned(Boolean banned) {
        isBanned = banned;
        return this;
    }
}
