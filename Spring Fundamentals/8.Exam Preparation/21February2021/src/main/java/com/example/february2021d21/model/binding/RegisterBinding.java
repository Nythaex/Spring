package com.example.february2021d21.model.binding;

import com.example.february2021d21.validation.UniqueEmail;
import com.example.february2021d21.validation.UniqueUsername;
import com.sun.xml.bind.v2.TODO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RegisterBinding {

    @UniqueUsername
    @Size(min = 3,max = 20)
    private String username;
    @Size(min = 3,max = 20)
    private String fullName;

    @UniqueEmail
    @Size(min = 1)
    @Email
    private String email;
    @Size(min = 5,max = 20)
    private String password;
    @Size(min = 3,max = 20)
    private String confirmPassword;

    public RegisterBinding(String username, String fullName, String email, String password, String confirmPassword) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public RegisterBinding() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterBinding setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterBinding setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterBinding setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterBinding setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBinding setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
