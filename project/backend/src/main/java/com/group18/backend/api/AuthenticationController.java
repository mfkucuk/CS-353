package com.group18.backend.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.dao.UserDataAccess;
import com.group18.backend.misc.LoginRequest;
import com.group18.backend.misc.LoginStatus;
import com.group18.backend.models.User;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class AuthenticationController 
{
    private final UserDataAccess userDataAccess;

    @PostMapping
    public LoginStatus login(@RequestBody LoginRequest request) 
    {
        final User user = userDataAccess.getUserByEmail(request.getEmail()).orElse(null);

        if (user != null) 
        {
            if (user.getPassword().equals(request.getPassword())) 
            {
                return new LoginStatus(true, user.getUserId());
            }
            else 
            {
                return new LoginStatus(false, user.getUserId());
            }
        }
        return new LoginStatus(false, null);
    }
}
