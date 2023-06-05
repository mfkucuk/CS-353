package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SystemReport 
{
    private String title;
    private String content;
    private UUID adminId;

    public SystemReport(@JsonProperty("title")String title, @JsonProperty("content")String content, @JsonProperty("adminId")UUID adminId) 
    {
        this.title = title; 
        this.content = content;
        this.adminId = adminId;
    }
}
