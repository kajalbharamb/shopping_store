package com.example.store.dto;

import javax.validation.constraints.NotEmpty;

public class Login {

    @NotEmpty(message = "Required Email")
    private String email;
    @NotEmpty(message = "Required Password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
