package com.example.february2021d21.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BasicEntity {

    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;

    public User(Long id, String username, String fullName, String password, String email) {
        super(id);
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
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
}
