package com.group18.backend.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.TravelerView;
import com.group18.backend.models.User;
import com.group18.backend.service.HomeownerService;
import com.group18.backend.service.TravelerService;
import com.group18.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController 
{
    private final UserService userService;

    @PostMapping
    public int insertUser(@RequestBody User user) 
    {
        return userService.insertUser(user);
    }

    @GetMapping(path = "id={id}")
    public User getUserById(@PathVariable("id") UUID id) 
    {
        return userService.getUserById(id).orElse(null);
    }

    @GetMapping(path = "email={email}")
    public User getUserByEmail(@PathVariable("email") String email) 
    {
        return userService.getUserByEmail(email).orElse(null);
    }

    @GetMapping()
    public List<User> getAllUsers() 
    {
        return userService.getAllUsers();
    }

    @PutMapping(path = "/id={id}/email={email}")
    public TravelerView updateEmailById(@PathVariable("id") UUID id, @PathVariable("email") String email) 
    {
        return userService.updateEmailById(id, email).orElse(null);
    }

    @PutMapping(path = "/id={id}/phone={phone}")
    public TravelerView updatePhoneById(@PathVariable("id") UUID id, @PathVariable("phone") String phone) 
    {
        return userService.updatePhoneById(id, phone).orElse(null);
    }

    @PutMapping(path = "/id={id}/password={password}")
    public TravelerView updatePasswordById(@PathVariable("id") UUID id, @PathVariable("password") String password) 
    {
        return userService.updatePasswordById(id, password).orElse(null);
    }
}
