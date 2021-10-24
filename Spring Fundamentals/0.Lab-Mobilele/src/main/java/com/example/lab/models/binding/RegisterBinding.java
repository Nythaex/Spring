package com.example.lab.models.binding;

import com.example.lab.models.entity.Enums.Role;
import com.example.lab.models.entity.UserRole;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBinding {
    @NotNull
    @Size(min = 4,max = 20)
    private String firstName;
    @NotNull
    @Size(min = 4,max = 20)
    private String lastName;
    @NotNull
    @Size(min = 4,max = 20)
    private String username;
    @NotNull
    @Size(min = 4,max = 20)
    private String password;
    @NotNull
    private Role userRole;

    public RegisterBinding(String firstName, String lastName, String username, String password, Role userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public RegisterBinding() {
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterBinding setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterBinding setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterBinding setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterBinding setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getUserRole() {
        return userRole;
    }

    public RegisterBinding setUserRole(Role userRole) {
        this.userRole = userRole;
        return this;
    }
}
