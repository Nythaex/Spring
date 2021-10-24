package com.example.exam.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends BasicEntity{
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Ship> Ships;


    public List<Ship> getShips() {
        return Ships;
    }

    public User setShips(List<Ship> ships) {
        Ships = ships;
        return this;
    }

    public User() {
    }

    public User(String username, String fullName, String password, String email) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
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
