package com.reservenow.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

// Landing Page for the API root
@RestController
public class ApiInfoController {

    // Handles GET /
    @GetMapping("/")
    public Map<String, String> getApiInfo() {
        Map<String, String> apiInfo = new LinkedHashMap<>();

        // LinkedHashMap keeps the order we insert values
        apiInfo.put("application", "ReserveNow Backend API");
        apiInfo.put("status", "running");
        apiInfo.put("description", "Spring Boot booking and reservation backend");
        apiInfo.put("usersEndpoint", "/api/users");
        apiInfo.put("authEndpoint", "/api/auth/login");
        apiInfo.put("listingsEndpoint", "/api/listings");
        apiInfo.put("bookingsEndpoint", "/api/bookings");

        return apiInfo;
    }
    // Health check endpoint for the API
    @GetMapping("/api/health")
    public Map<String, String> healthCheck() {
        return Map.of(
                "status", "UP",
                "service", "ReserveNow API"
        );
    }
}