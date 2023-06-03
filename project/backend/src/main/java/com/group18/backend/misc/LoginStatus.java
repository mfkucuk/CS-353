package com.group18.backend.misc;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginStatus
{
    private boolean successfull;
    private UUID userId;

    public LoginStatus(
        @JsonProperty("successfull") boolean successfull,
        @JsonProperty("userId") UUID userId
    )
    {
        this.successfull = successfull;
        this.userId = userId;
    }
}
