package com.group18.backend.misc;

import lombok.Data;

@Data
public class HomeownerReputation 
{
    private String fullName;
    private float reputation;

    public HomeownerReputation(
        String fullName,
        float reputation
    )
    {
        this.fullName = fullName;
        this.reputation = reputation;
    }
}
