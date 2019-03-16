package com.apt.project4.payload;

import com.apt.project4.constant.MessageKeys;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class JwtAuthenticationRequest {

    @NotBlank
    @Email(message = MessageKeys.INVALID_EMAIL_FORMAT)
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
    }
}
