package com.group18.misc;

import lombok.Data;

@Data
public class LocationCount 
{
    private String location;
    private int count;

    public LocationCount(String location, int count) 
    {
        this.location = location;
        this.count = count;
    }
}
