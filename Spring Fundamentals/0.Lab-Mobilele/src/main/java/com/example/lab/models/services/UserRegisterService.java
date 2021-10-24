package com.example.lab.models.services;

import com.example.lab.models.binding.RegisterBinding;
import com.example.lab.models.entity.Enums.Role;
import com.example.lab.models.entity.UserRole;

public class UserRegisterService {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserRole userRole;

    public UserRegisterService(String firstName, String lastName, String username, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public UserRegisterService() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterService setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterService setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterService setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterService setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public UserRegisterService setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
