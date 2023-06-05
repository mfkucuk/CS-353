package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Admin 
{
    private UUID userId;
    private String pastReports;

    public Admin(
        @JsonProperty("userId") UUID userId,
        @JsonProperty("pastReports") String pastReports
    )
    {
        this.userId = userId;
        this.pastReports = pastReports;
    }
}
