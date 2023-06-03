package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HomeownerView extends TravelerView {

    private String receivedReviews;
    private float reputation;

    public HomeownerView(
        UUID userId, 
        String fullName, 
        String email, 
        LocalDate dob, 
        String TCK, 
        String password,
        String phoneNumber, 
        boolean isAdmin,
        String writtenReviews,
        float balance,
        String receivedReviews,
        float reputation
    ) 
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber, isAdmin, writtenReviews, balance);
        this.receivedReviews = receivedReviews;
        this.reputation = reputation;
    }
    
}
