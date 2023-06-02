package com.group18.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.Admin;
import com.group18.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController 
{
    private final AdminService adminService;

    @PostMapping
    public int insertAdmin(@RequestBody Admin admin) 
    {
        return adminService.insertAdmin(admin);
    }
}
