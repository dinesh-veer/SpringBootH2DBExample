
# Spring Boot H2 DB Example

A simple Spring Boot application demonstrating how to integrate and use an H2 in-memory database for development and testing, with CRUD operations for a `Student` entity.

---

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [Accessing H2 Console](#accessing-h2-console)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Tech Stack](#tech-stack)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)
- [License](#license)

---

## Features

- Spring Boot application
- H2 in-memory database
- CRUD operations for Student entity
- RESTful API using Spring Web
- H2 console for debugging and development

---

## Prerequisites

- Java 8 or higher
- Maven or Gradle

---

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/dinesh-veer/SpringBootH2DBExample.git
   cd SpringBootH2DBExample
   ````

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

---

## Project Structure

```
SpringBootH2DBExample/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.demo/
│   │   │       ├── Application.java
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (optional)
└── pom.xml
```

---

## Usage

### Running the Application

Start the application using Maven:

```bash
mvn spring-boot:run
```

The app will be accessible at: `http://localhost:8080`

### Accessing H2 Console

* URL: `http://localhost:8080/h2`
* JDBC URL: `jdbc:h2:mem:memDb;DB_CLOSE_DELAY=-1`
* Username: `sa`
* Password: *(leave blank)*

---

## Configuration

### `application.properties`

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=none
```

---

## API Endpoints

| Method | Endpoint        | Description                |
| ------ | --------------- | -------------------------- |
| GET    | `/student`      | Get all students           |
| GET    | `/student/{id}` | Get a student by ID        |
| POST   | `/student`      | Create a new student       |
| PUT    | `/student/{id}` | Update an existing student |
| DELETE | `/student/{id}` | Delete a student by ID     |

---

## Tech Stack

* Java 8+
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven

---

## Testing

You can use Spring Boot Test and H2 to write integration tests without affecting real data.

---

## Troubleshooting

* **H2 Console not loading**: Ensure the H2 console is enabled and accessible via `/h2-console`.
* **CSRF Issues with H2 Console**: If using Spring Security, you may need to disable CSRF and allow frame options for the console.

---

## 📝 License

This project is licensed under the [MIT License](LICENSE).

---

## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---