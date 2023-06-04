package com.group18.backend.misc;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FilterBody 
{
    private String rentalType;
    private float minPrice;
    private float maxPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public FilterBody(
        @JsonProperty("rentalType") String rentalType,
        @JsonProperty("minPrice") float minPrice,
        @JsonProperty("maxPrice") float maxPrice,
        @JsonProperty("startDate") LocalDate startDate,
        @JsonProperty("endDate") LocalDate endDate
    )
    {
        this.rentalType = rentalType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
