package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TravelerView extends User {
    
    private String writtenReviews;
    private Float balance;

    public TravelerView(
        @JsonProperty("userId") UUID userId,
        @JsonProperty("fullName") String fullName,
        @JsonProperty("email") String email,
        @JsonProperty("dob") LocalDate dob,
        @JsonProperty("TCK") String TCK,
        @JsonProperty("password") String password,
        @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("writtenReviews")String writtenReviews,
        @JsonProperty("balance")Float balance
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber);
        this.writtenReviews = writtenReviews;
        this.balance = balance;
    }
}
