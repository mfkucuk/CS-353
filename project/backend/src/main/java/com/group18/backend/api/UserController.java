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

import com.group18.backend.models.HomeownerView;
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

    @PutMapping(path = "/t/id={id}/email={email}")
    public TravelerView updateEmailByIdT(@PathVariable("id") UUID id, @PathVariable("email") String email) 
    {
        return userService.updateEmailByIdT(id, email).orElse(null);
    }

    @PutMapping(path = "/t/id={id}/phone={phone}")
    public TravelerView updatePhoneByIdT(@PathVariable("id") UUID id, @PathVariable("phone") String phone) 
    {
        return userService.updatePhoneByIdT(id, phone).orElse(null);
    }

    @PutMapping(path = "/t/id={id}/password={password}")
    public TravelerView updatePasswordByIdT(@PathVariable("id") UUID id, @PathVariable("password") String password) 
    {
        return userService.updatePasswordByIdT(id, password).orElse(null);
    }

    @PutMapping(path = "/h/id={id}/email={email}")
    public HomeownerView updateEmailByIdH(@PathVariable("id") UUID id, @PathVariable("email") String email) 
    {
        return userService.updateEmailByIdH(id, email).orElse(null);
    }

    @PutMapping(path = "/h/id={id}/phone={phone}")
    public HomeownerView updatePhoneByIdH(@PathVariable("id") UUID id, @PathVariable("phone") String phone) 
    {
        return userService.updatePhoneByIdH(id, phone).orElse(null);
    }

    @PutMapping(path = "/h/id={id}/password={password}")
    public HomeownerView updatePasswordByIdH(@PathVariable("id") UUID id, @PathVariable("password") String password) 
    {
        return userService.updatePasswordByIdH(id, password).orElse(null);
    }
}
