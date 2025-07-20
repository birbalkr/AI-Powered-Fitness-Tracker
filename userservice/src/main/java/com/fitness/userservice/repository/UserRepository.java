    package com.fitness.userservice.repository;

    import com.fitness.userservice.model.User;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository // Marks this as a Spring-managed repository bean
    public interface UserRepository extends JpaRepository<User, String> {

        // Checks if a user already exists by their email address
        boolean existsByEmail(
                @NotBlank(message = "Email is required")
                @Email(message = "Invalid email format") String email
        );
    }