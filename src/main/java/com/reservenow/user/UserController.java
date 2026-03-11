package com.reservenow.user;

import com.reservenow.user.dto.UserRequest;
import com.reservenow.user.dto.UserResponse;
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

    // Creates a user from request JSON and returns a safe response (HTTP POST)
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    // Returns all users without exposing passwords (HTTP GET)
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}