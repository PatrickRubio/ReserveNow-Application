# ReserveNow - Enterprise Booking & Reservation Backend

Java 21 | Spring Boot | PostgreSQL | Spring Data JPA | Hibernate | REST APIs | BCrypt | Railway

ReserveNow is a backend REST API for a booking and reservation platform. The application allows users to create accounts, log in securely, create listings, and make bookings for available services or spaces.

---

## Live Backend API

- **API Root:** https://reservenow-application-production.up.railway.app/
- **Health Check:** https://reservenow-application-production.up.railway.app/api/health

---

## Features

- User registration with validation
- Secure password hashing using BCrypt
- Login endpoint with credential verification
- Create and retrieve bookable listings
- Create and retrieve bookings
- Booking status support: `PENDING`, `CONFIRMED`, `CANCELLED`
- PostgreSQL database persistence
- DTO-based request and response handling
- Global exception handling with clean JSON error responses
- Environment-variable based database configuration for deployment

---

## API Endpoints

### Users

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Create a new user |
| GET | `/api/users` | Get all users |

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/login` | Log in with email and password |

### Listings

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/listings` | Create a listing |
| GET | `/api/listings` | Get all listings |

### Bookings

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/bookings` | Create a booking |
| GET | `/api/bookings` | Get all bookings |

### System

| Method | Endpoint | Description |
|---|---|---|
| GET | `/` | API landing response |
| GET | `/api/health` | Health check |

---

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA, Hibernate
- **Security:** BCrypt password hashing
- **Validation:** Jakarta Bean Validation
- **Testing:** Postman
- **Deployment:** Railway
- **Tools:** IntelliJ IDEA, Maven, Git, GitHub, pgAdmin

---

## Architecture

The application follows a layered backend architecture:

```text
Controller → Service → Repository → Hibernate/JPA → PostgreSQL
```

DTOs are used to separate API request and response models from database entities.

---

## Project Structure

```text
com.reservenow
├── auth
├── booking
├── common
├── exception
├── listing
└── user
```

---

## Installation & How to Run Locally

### Prerequisites

- Java 21
- Maven
- PostgreSQL
- IntelliJ IDEA
- Postman

### Clone the Repository

```bash
git clone https://github.com/your-username/reservenow.git
cd reservenow/demo
```

### Create PostgreSQL Database

```sql
CREATE DATABASE reservenow;
```

### Configure Environment Variables

```text
RESERVENOW_DATABASE_URL=jdbc:postgresql://localhost:5432/reservenow
RESERVENOW_DATABASE_USERNAME=postgres
RESERVENOW_DATABASE_PASSWORD=your-password
```

### Run the Application

```bash
mvn spring-boot:run
```

The API will run at:

```text
http://localhost:8080
```

---

## Sample Login Request

```json
{
  "email": "testuser@example.com",
  "password": "password123"
}
```

---

## Testing

Tested using Postman for:

- User creation
- Login authentication
- Listing creation
- Booking creation
- Validation errors
- Duplicate email handling
- Invalid login handling
- PostgreSQL persistence

---

## Learning Objectives

- Java backend development
- Spring Boot REST API design
- Layered architecture
- DTOs and validation
- PostgreSQL integration
- Hibernate/JPA entity mapping
- Global exception handling
- Password hashing with BCrypt
- Environment-variable configuration
- Cloud deployment preparation

---

## Future Enhancements

- Add JWT authentication
- Add role-based authorization
- Add booking cancellation
- Add provider listing ownership
- Add Swagger/OpenAPI documentation
- Add Docker support
- Add payment simulation
- Add unit and integration tests
- Add frontend dashboard

---

## Author

Patrick Rubio

LinkedIn: https://www.linkedin.com/in/patrick-rubio-a60587190/
