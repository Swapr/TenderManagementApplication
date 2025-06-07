# Tender Management Application

This is a Spring Boot-based **Tender Management System** that implements **JWT (JSON Web Token)** authentication and **role-based access control** using Spring Security.

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3.4
- Spring Security
- JWT Authentication
- Spring Data JPA (Hibernate)
- Swagger (SpringDoc OpenAPI)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Swapr/TenderManagementApplication.git
```

### 2. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```
### 3. Access Swagger UI
Once the application is running, open your browser and go to:
```bash
http://localhost:8080/swagger-ui.html
```
📘 Swagger API Docs
Use Swagger UI to test all public and secured endpoints, including those requiring JWT tokens.

🔐 JWT Authentication
Use the /login endpoint with valid credentials to receive a JWT token.

Click the Authorize button on Swagger UI and enter the token without double quates:

🛡️ User Roles
Supported roles in the application:

ROLE_BIDDER

ROLE_APPROVER

Role-based access is controlled using Spring Security annotations like @PreAuthorize


