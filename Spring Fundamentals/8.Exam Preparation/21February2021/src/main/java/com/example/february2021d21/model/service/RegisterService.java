package com.example.february2021d21.model.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RegisterService {
    private String username;
    private String fullName;
    private String email;
    private String password;

    public RegisterService(String username, String fullName, String email, String password) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public RegisterService() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterService setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterService setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterService setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterService setPassword(String password) {
        this.password = password;
        return this;
    }
}
