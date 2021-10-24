package com.example.february2021d21.model.binding;

import javax.validation.constraints.Size;

public class LoginBinding {
    @Size(min = 3,max = 20)
    private String username;
    @Size(min = 5,max = 20)
    private String password;

    public LoginBinding(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public LoginBinding() {

    }

    public String getUsername() {
        return username;
    }

    public LoginBinding setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginBinding setPassword(String password) {
        this.password = password;
        return this;
    }
}
