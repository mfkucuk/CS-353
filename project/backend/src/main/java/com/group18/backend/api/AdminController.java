package com.group18.backend.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.Admin;
import com.group18.backend.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
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
