package com.group18.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Admin extends User{

    private String pastReports;

    public Admin(
        UUID userId,
        String fullName,
        String email,
        LocalDateTime dob,
        String TCK,
        String password,
        String phoneNumber,
        String pastReports
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber);
        this.pastReports = pastReports;
    }
}
