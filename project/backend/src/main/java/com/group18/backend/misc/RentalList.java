package com.group18.backend.misc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group18.backend.models.Rental;

import lombok.Data;

@Data
public class RentalList 
{
    private List<Rental> previousAccomodations;
    private List<Rental> currentAccomodations;

    public RentalList(
        @JsonProperty("previousAccomodations") List<Rental> previousAccomodations,
        @JsonProperty("currentAccodomations") List<Rental> currentAccomodations
    )
    {
        this.previousAccomodations = previousAccomodations;
        this.currentAccomodations = currentAccomodations;
    }
}
