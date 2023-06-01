package com.group18.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.User;
import com.group18.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
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
}
