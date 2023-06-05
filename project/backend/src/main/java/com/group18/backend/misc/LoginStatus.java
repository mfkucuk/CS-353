package com.group18.backend.misc;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginStatus
{
    private boolean successful;
    private UUID userId;

    public LoginStatus(
        @JsonProperty("successful") boolean successful,
        @JsonProperty("userId") UUID userId
    )
    {
        this.successful = successful;
        this.userId = userId;
    }
}
