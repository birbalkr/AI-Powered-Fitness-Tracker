# 🧑‍💻 User Service – Fitness App

This is a Spring Boot-based User Service for a fitness tracking application. It handles user registration and profile retrieval using a clean architecture, DTO separation, and secure practices.

---

## 🚀 Features

- ✅ User registration with email uniqueness check
- ✅ User profile retrieval by ID
- ✅ Uses DTOs to separate internal and external data models
- ✅ Field validation using Jakarta `@Valid`
- ✅ Optional: BCrypt password hashing (recommended for production)
- ✅ Ready to integrate into monolith or microservices architecture

---

## 🛠 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Jakarta Validation (Bean Validation API)**
- **H2 / MySQL / PostgreSQL** (choose as needed)

---

## 📁 Project Structure

com.fitness.userservice
├── controller # REST API endpoints
├── dto # DTOs for requests & responses
├── model # JPA entity (User)
├── repository # UserRepository (JPA interface)
├── service # UserService (business logic)
└── UserserviceApplication.java
