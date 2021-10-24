package com.example.lab.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isLoggedIn;
    private String role;

    public String getRole() {
        return role;
    }

    public CurrentUser setRole(String role) {
        this.role = role;
        return this;
    }

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }
}
