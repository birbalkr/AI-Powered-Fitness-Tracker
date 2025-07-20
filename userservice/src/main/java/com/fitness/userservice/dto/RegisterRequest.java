package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is required") // Cannot be empty
    @Email(message = "Invalid email format") // Must be a valid email
    private String email;

    @NotBlank(message = "Password is required") // Cannot be empty
    @Size(min = 6, message = "Password must have 6 characters") // Minimum length 6
    private String password;

    @NotBlank(message = "Name is required") // Cannot be empty
    private String firstName;

    private String lastName;
}
