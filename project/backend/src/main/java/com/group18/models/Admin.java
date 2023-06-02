package com.group18.models;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Admin 
{
    private UUID userId;
    private String pastReports;

    public Admin(
        UUID userId,
        String pastReports
    )
    {
        this.userId = userId;
        this.pastReports = pastReports;
    }
}
