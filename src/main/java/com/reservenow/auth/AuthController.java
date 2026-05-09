package com.reservenow.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Spring injects AuthService here
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // POST/Create  Login
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}