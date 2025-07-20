package com.fitness.userservice.controller;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Defines this class as a REST controller
@RequestMapping("/api/users") // Base URL path for all user endpoints
@AllArgsConstructor // Generates constructor with all arguments (injects UserService)
public class UserController {

    private UserService userService;

    // GET /api/users/{userId} - fetch user profile by userId
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    // POST /api/users/register - register a new user
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}