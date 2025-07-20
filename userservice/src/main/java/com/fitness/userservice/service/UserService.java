package com.fitness.userservice.service;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service bean
public class UserService {

    @Autowired // Injects UserRepository dependency
    private UserRepository repository;

    // Register a new user with validation
    public UserResponse register(@Valid RegisterRequest request) {

        // Check if email is already used
        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

            // Create and fill User entity from request data
            User user= new User();
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());

            // Save user to database
            User saveuser = repository.save(user);

            // Convert saved user to UserResponse DTO to send back
            UserResponse userResponse =new UserResponse();
            userResponse.setId(saveuser.getId());
            userResponse.setPassword(saveuser.getPassword());
            userResponse.setEmail(saveuser.getEmail());
            userResponse.setFirstName(saveuser.getFirstName());
            userResponse.setLastName(saveuser.getLastName());
            userResponse.setCreatedAt(saveuser.getCreatedAt());
            userResponse.setUpdatedAt(saveuser.getUpdatedAt());
//
            return userResponse;

    }
    // Get user profile by ID
    public UserResponse getUserProfile(String userId) {
            User user = repository.findById(userId)
                    .orElseThrow(()-> new RuntimeException("User Not Found"));

        UserResponse userResponse =new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }
}
