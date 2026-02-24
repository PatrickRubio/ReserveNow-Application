package com.reservenow.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;

// REST controller
@RestController

// Base URL mapping for ALL methods in this class
@RequestMapping("/api/users")
public class UserController {
    // Spring injects dependency injection automatically
    private final UserService userService;

    // Spring sees this as a constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // CREATE USER (HTTP POST)
    @PostMapping
    public User createUser(
            @RequestBody User user
    ) {
        // This calls the service layer
        return userService.createUser(user);
    }
    // GET ALL USERS (HTTP GET)
    @GetMapping
    public List<User> getAllUsers() {

        // Spring automatically converts list into JSON
        return userService.getAllUsers();
    }
}