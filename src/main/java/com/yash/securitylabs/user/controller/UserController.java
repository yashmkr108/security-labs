package com.yash.securitylabs.user.controller;

import com.yash.securitylabs.user.dto.UserRequest;
import com.yash.securitylabs.user.dto.UserResponse;
import com.yash.securitylabs.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest request){
        return userService.createUser(request);
    }
}
