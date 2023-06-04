package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdminView extends User{
    private UUID userId;
    private String pastReports;

    public AdminView(
        @JsonProperty("userId") UUID userId,
        @JsonProperty("fullName") String fullName,
        @JsonProperty("email") String email,
        @JsonProperty("dob") LocalDate dob,
        @JsonProperty("TCK") String TCK,
        @JsonProperty("password") String password,
        @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("isAdmin") boolean isAdmin,
        @JsonProperty("pastReports") String pastReports
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber, isAdmin);
        this.userId = userId;
        this.pastReports = pastReports;
    }
}
