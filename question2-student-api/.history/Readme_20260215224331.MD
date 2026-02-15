# Student Registration API

A Spring Boot REST API designed for managing student records, featuring advanced filtering by academic major and GPA thresholds.

## Features

* Full Registry: List all registered students
* ID Lookup: Retrieve detailed information for a specific student
* Major Filtering: Group students by their field of study using Path Variables
* GPA Thresholds: Filter students based on academic performance using Query Parameters
* Registration & Updates: Add new students or modify existing records

## Getting Started

### Prerequisites

* Java 17 or 21
* Maven
* Postman (for testing POST/PUT requests)

### How to Run

1. Navigate to the project folder:
   ```bash
   cd question2-student-api
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The API will be available at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description | Key Params |
|--------|----------|-------------|------------|
| GET | `/api/students` | Get all students | None |
| GET | `/api/students/{id}` | Get student by ID | `studentId` (Path) |
| GET | `/api/students/major/{major}` | Get students by major | `major` (Path) |
| GET | `/api/students/filter` | Filter by GPA | `gpa` (Query) |
| POST | `/api/students` | Register new student | Request Body |
| PUT | `/api/students/{id}` | Update student info | Request Body |

## Testing Scenarios

### 1. Filter by Major (Computer Science)

**GET** `http://localhost:8080/api/students/major/Computer Science`

Sample Response:
```json
[
    {
        "studentId": 1,
        "firstName": "Alice",
        "lastName": "Smith",
        "email": "alice@edu.com",
        "major": "Computer Science",
        "gpa": 3.8
    },
    {
        "studentId": 3,
        "firstName": "Charlie",
        "lastName": "Brown",
        "email": "charlie@edu.com",
        "major": "Computer Science",
        "gpa": 3.5
    }
]
```

### 2. Filter by GPA (>= 3.5)

**GET** `http://localhost:8080/api/students/filter?gpa=3.5`

Expected Behavior: Returns all students with a GPA of 3.5 or higher.

### 3. Update Student Information

**PUT** `http://localhost:8080/api/students/5`

Request Body:
```json
{
    "firstName": "Ethan",
    "lastName": "Hunt",
    "email": "ethan.new@edu.com",
    "major": "Cyber Security",
    "gpa": 4.0
}
```

## Project Structure

* **Model Package**: `com.library.question2studentapi.model`
* **Controller Package**: `com.library.question2studentapi.controller`

