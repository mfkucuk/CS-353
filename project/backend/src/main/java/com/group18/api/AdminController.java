package com.group18.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "id={id}")
    public Admin getAdminById(@PathVariable("id") UUID id) 
    {
        return adminService.getAdminById(id).orElse(null);
    }

    @GetMapping(path = "email={email}")
    public Admin getAdminByEmail(@PathVariable("email") String email) 
    {
        return adminService.getAdminByEmail(email).orElse(null);
    }

    @GetMapping()
    public List<Admin> getAllAdmins() 
    {
        return adminService.getAllAdmins();
    }
}
