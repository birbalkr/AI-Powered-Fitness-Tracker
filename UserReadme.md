# AI-Powered-Fitness-Tracker
# 🧑‍💻 1. User Service – Fitness App

This is a Spring Boot-based User Service for a fitness tracking application. It handles user registration and profile retrieval using a clean architecture, DTO separation, and secure practices.

---

## 🚀 Features

- ✅ User registration with email
- ✅ User profile retrieval by ID
- ✅ Uses DTOs to separate internal and external data models
- ✅ Field validation using Jakarta `@Valid`

---

# 🛠 Tech Stack

- **Java 21+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Jakarta Validation (Bean Validation API)**
- **PostgreSQL**

---

# 📁 Userservice File Structure 

```bash

├── controller              # REST API endpoints (e.g., UserController)
│   ├── UserController.java 
│   └──# This UserController handles HTTP requests for user actions. It maps:
│      # GET /api/users/{userId} to fetch a user’s profile by ID.
│      # POST /api/users/register to register a new user with validation.
│      # It uses UserService to process the requests and sends back the appropriate responses.
│  
├── dto                     # Data Transfer Objects (used for requests and responses)  
│   ├── RegisterRequest.java
│   ├── # This RegisterRequest class is a data transfer object (DTO) used to receive and validate user registration data. It ensures the email is valid, the password is at least 6 characters, and required fields like email, password, and first name are not empty before processing the registration. 
│   ├── UserResponse.java 
│   └── # This UserResponse class is a data transfer object (DTO) used to send user details back to the client. It holds user info like ID, email, name, and timestamps, typically after a successful request like login or fetching user data.
│  
├── model                   # JPA entities and enums  
│   ├── User.java 
│   ├── # This class is used in Spring Boot to save user information into the database easily. It helps create a table for users, and you don’t need to write SQL code — Spring handles it for you.
│   ├── UserRole.java 
│   └── # This UserRole enum defines the type of users in the system. It has two roles: USER and ADMIN. Enums like this are used to restrict and organize user roles clearly and safely in the code.
│ 
├── repository              # Database access layer (Spring Data JPA)  
│   ├── UserRepository.java 
│   └── # This UserRepository interface handles database operations for the User entity using Spring Data JPA. It provides built-in methods (like save, find) and adds a custom method existsByEmail to check if a user with a specific email already exists.
│ 
├── service                 # Business logic layer  
│   ├── UserService.java  
│   └── # This UserService class contains the business logic for user actions. It handles registering new users by checking if the email already exists, saving user data, and returning a response. It also fetches a user's profile by ID, throwing an error if the user is not found. This separates the core logic from the controller and repository layers.
└── UserserviceApplication.java   # Main Spring Boot application class

```
## Summary
### 1. Model Layer: User and UserRole
   User.java

    Defines the User entity which represents a user in the database.
    Annotated with @Entity and @Table(name="users") to map it to the users table.
    Fields like id, email, password, firstName, lastName, and role store user data.
    Uses @Id and @GeneratedValue to automatically generate a unique ID.
    @CreationTimestamp and @UpdateTimestamp track when the user was created and last updated.
    @Data (Lombok) generates boilerplate code like getters/setters automatically.
    UserRole.java
    Defines possible roles a user can have: USER or ADMIN.
    This enum restricts the values allowed for user roles in the system.
### 2. DTO Layer (Data Transfer Objects):
   RegisterRequest.java

        Defines the structure for user registration input.
        Uses validation annotations like @NotBlank and @Email to ensure data is valid (e.g., email format, password length).
        This object is used to safely receive user registration data from client requests.

   UserResponse.java

        Defines the structure for user data sent back to the client.
        Includes fields like id, email, firstName, lastName, and timestamps.
        Used to control what user info is returned (e.g., may exclude sensitive info like raw password if needed).
### 3. Repository Layer:
   UserRepository.java

    Extends JpaRepository which provides built-in methods for database operations like save, find, delete, etc.
    Adds a custom method existsByEmail to check if a user with a certain email already exists in the database.
    Marked with @Repository so Spring knows it's a DAO component.
### 4. Service Layer:
   UserService.java

    Contains business logic related to user operations.
    register(RegisterRequest request):
    Checks if the email is already taken using existsByEmail.
    If not, creates a new User, sets its fields, and saves it.
    Converts the saved user entity to a UserResponse to return.
    getUserProfile(String userId):
    Finds a user by their ID.
    Throws an error if user not found.
Returns user details wrapped in a UserResponse.
### 5. Controller Layer:
   UserController.java

    Exposes HTTP endpoints for user-related operations.
    @RestController marks this as a REST API controller.
    @RequestMapping("/api/users") sets the base path for all user routes.
    GET /{userId} endpoint calls the service to get user profile by ID.
    POST /register endpoint accepts a registration request, validates it, and calls the service to register a new user.
    Returns the response wrapped in a ResponseEntity to include HTTP status codes.
### Summary of Flow:

Client sends a request to register a user (POST /api/users/register) or get user profile (GET /api/users/{userId}).
The controller receives the request and calls the appropriate service method.
The service performs validation, business logic, and uses the repository to interact with the database.
The repository executes database queries (save, find, check existence).
The service returns a DTO (UserResponse) which the controller sends back to the client as JSON.
If you want, I can also help you with specific parts like adding password encryption or improving error handling! Would you like that?









