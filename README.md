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
























