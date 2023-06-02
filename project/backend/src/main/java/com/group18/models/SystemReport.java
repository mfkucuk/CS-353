package com.group18.models;

import java.util.UUID;

import lombok.Data;

@Data
public class SystemReport 
{
    private String title;
    private String content;
    private UUID adminId;

    public SystemReport(String title, String content, UUID adminId) 
    {
        this.title = title; 
        this.content = content;
        this.adminId = adminId;
    }
}
