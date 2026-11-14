# BookMyHall – Hall Booking Management System

BookMyHall is a full-stack web application designed to simplify the process of discovering, managing, and booking halls for different events and occasions. It provides a centralized platform where consumers can explore available halls and make hourly or daily reservations, while hall owners can manage their properties and bookings.

The application also provides an administration dashboard for managing users, halls, and platform activities.

## 🚀 Key Features

### 1. Role-Based Authentication and Authorization
- Secure user registration and login.
- Role-based access control.
- Three user roles:
  - **ADMIN:** Manages users, halls, and overall platform activities.
  - **HALL OWNER:** Creates and manages hall listings, images, and bookings.
  - **CONSUMER:** Browses halls and makes reservations.

### 2. Hall Management
- Add, update, and delete hall details.
- Upload and manage hall images.
- Display hall information and availability.
- Manage hall listings based on ownership.

### 3. Booking Management
- Hourly and daily booking options.
- Check hall availability before confirming reservations.
- View and manage booking details.
- Prevent overlapping reservations.
- Manage pending and confirmed bookings.

### 4. Concurrency Management
Implements database-level concurrency control to maintain booking consistency when multiple users attempt to reserve the same hall.

- **Pessimistic Locking:** Uses database row-level locking to prevent concurrent booking conflicts.
- Transactional booking operations.
- Validates existing reservations before creating a new booking.
- Returns appropriate conflict responses when a requested time slot is already reserved.
- Uses expiring pending reservations to manage temporary booking holds.

## 🛠️ Technology Stack

| Category | Technologies |
|---|---|
| Backend | Java 25, Spring Boot |
| ORM | Hibernate, Spring Data JPA |
| Frontend | Angular 16, TypeScript |
| UI | HTML, CSS, Bootstrap |
| Database | MySQL |
| Database Migration | Flyway |
| Authentication | Spring Security, Session-Based Authentication |
| Build Tool | Maven |
| API Testing | Postman |

## 🏗️ Application Architecture

The application follows a layered architecture to maintain separation of concerns and make the code easier to maintain.

**Backend Layers:**
- Controller Layer – Handles incoming HTTP requests and API responses.
- Service Layer – Contains business logic and booking validations.
- Repository Layer – Handles database operations using Spring Data JPA.
- Entity Layer – Defines database entities and relationships.
- DTO Layer – Manages request and response data.

**Frontend:**
- Angular components for different dashboards.
- Services for backend API communication.
- Role-based dashboard navigation.
- Reusable components for hall and booking management.

## 📅 Booking Workflow

1. Consumer browses the available halls.
2. Consumer selects a hall and booking type (hourly or daily).
3. Consumer selects the required date and time.
4. Backend validates the requested booking period.
5. Database locking ensures concurrent booking requests are handled safely.
6. If the time slot is available, a pending reservation is created.
7. The booking status is managed through the booking workflow.

## 🔒 Booking Conflict Prevention

The application uses pessimistic locking with database transactions to prevent two users from booking the same hall for overlapping time slots.

The overlap validation follows this condition:

`existingStart < requestedEnd AND existingEnd > requestedStart`

Only pending and confirmed reservations are considered during availability validation.

Conflicting booking requests receive an HTTP `409 Conflict` response.

## 🗄️ Database Management

- MySQL for persistent data storage.
- Hibernate and Spring Data JPA for ORM and database operations.
- Flyway for database schema migration and version management.
- JPA schema validation using `ddl-auto=validate`.

## ⚙️ Installation and Setup

### Prerequisites

- Java 25 or later
- Node.js and npm
- Angular CLI 16
- MySQL 8
- Maven

### 1. Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
```

### 2. Backend Setup

Navigate to the backend project directory.

Configure your database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/core
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
```

Run the Spring Boot application:

```bash
mvn clean install
mvn spring-boot:run
```

Backend runs at:

`http://localhost:8080`

### 3. Frontend Setup

Navigate to the Angular project directory:

```bash
npm install
```

Start the Angular development server:

```bash
ng serve
```

Frontend runs at:

`http://localhost:4200`

## 🎯 Project Objectives

- Simplify hall discovery and reservation.
- Provide separate dashboards for different user roles.
- Maintain accurate hall availability.
- Prevent duplicate and overlapping bookings.
- Implement reliable transaction management.
- Build a maintainable full-stack application using modern technologies.

## 👨‍💻 Developer

**Saud Khan**

Java Backend Developer | Spring Boot | Hibernate | Angular | MySQL

[GitHub](https://github.com/saud9422) | [LinkedIn](https://linkedin.com/in/saud-khan-5b5b23261)
