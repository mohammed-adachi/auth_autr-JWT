# Secure User Authentication System with JWT

This project implements a **Secure User Authentication System** using **JWT (JSON Web Tokens)** for login and registration functionality. It includes secure user sign-up, login, and access to protected routes only after successful authentication. The system uses **Spring Boot** for the backend, **Angular** for the frontend, and **MySQL** for the database.

## Features

- **User Registration**: Secure user registration with password hashing using bcrypt.
- **Secure Login**: Login functionality using JWT tokens to authenticate users.
- **Protected Routes**: Only authenticated users with valid JWT tokens can access protected routes.
- **Password Hashing**: Passwords are hashed before being stored in the database for security.
- **Session Management**: JWT tokens are used for session management and authentication.
- **Role-Based Access Control (RBAC)**: Users are assigned specific roles to access different routes.

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Frontend**: Angular
- **API Testing**: Postman (or Boostman)
- **Authentication**: JSON Web Tokens (JWT)
- **Password Hashing**: bcrypt
- **Database**: MySQL

## Prerequisites

- **Node.js** and **Angular CLI** installed for the frontend.
- **MySQL** installed for database.
- **Spring Boot** setup for the backend.
- **Postman** (or Boostman) for testing API endpoints.

## Installation Instructions

### 1. Clone the Repository
Clone the repository to your local machine:
```bash
git clone https://github.com/mohammed-adachi/auth_autr-JWT.git
###Create a MySQL Database:CREATE DATABASE auth_autr;
### Frontend Setup (Angular)
cd my-app
ng serve
The frontend application will be accessible at http://localhost:4200.
 ### API Testing (Postman)
localhost:8082//account/register
POST{
  "username": "user1",
  "email": "user1@example.com",
  "password": "securepassword"
} 
localhost:8082//account/login
POST{
  "username": "user1",
  "password": "securepassword"
}

