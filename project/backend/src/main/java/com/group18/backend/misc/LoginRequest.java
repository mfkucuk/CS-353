package com.group18.backend.misc;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest
{
    private String email;
    private String password;

    public LoginRequest(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password
    )
    {
        this.email = email;
        this.password = password;
    }
}
