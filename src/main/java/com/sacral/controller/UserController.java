package com.sacral.controller;

import com.sacral.model.User;
import com.sacral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/users/{username}/{password}")
    public User getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return userService.findByUsernameAndPassword(username, password);
    }

    // Add additional methods for password reset, user roles, etc.
}