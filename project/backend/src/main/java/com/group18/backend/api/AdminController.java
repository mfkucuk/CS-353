package com.group18.backend.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.Admin;
import com.group18.backend.models.AdminView;
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

    @GetMapping(path = "id={id}")
    public AdminView getUserById(@PathVariable("id") UUID id) 
    {
        return adminService.getAdminByID(id).orElse(null);
    }
}
