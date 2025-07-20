package com.fitness.userservice.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity // Marks this class as a database entity
@Table(name="users") // Maps to "users" table in the database
@Data // Lombok generates getters, setters, toString, etc.
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.UUID) // Auto-generates a UUID for id
    private String id;

    @Column(unique = true, nullable = false) // Email must be unique and not null
    private String email;

    @Column(nullable = false) // Password cannot be null
    private String password;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING) // Stores enum as a string in the DB
    private UserRole role = UserRole.USER; // Default role is USER

    @CreationTimestamp // Automatically set when record is created
    private LocalDateTime createdAt;

    @UpdateTimestamp // Automatically updated on changes
    private LocalDateTime updatedAt;
}
