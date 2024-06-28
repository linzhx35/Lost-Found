package com.example.LostAndFoundSystem.controller;

import com.example.LostAndFoundSystem.entity.User;
import com.example.LostAndFoundSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for managing users
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public User login(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public void register(@RequestBody User user) {
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
