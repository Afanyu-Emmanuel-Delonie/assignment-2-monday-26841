# Task Management API

A specialized REST API for task tracking and project management, featuring priority-based filtering and status updates.

## Features

* Priority Classification: Organize tasks by "HIGH", "MEDIUM", or "LOW" priority levels
* Status Filtering: Easily separate completed tasks from those still in progress
* Partial Completion Updates: Uses the `PATCH` method to quickly mark tasks as finished without sending the entire task object
* Deadline Tracking: Tasks include due dates to assist with time management and scheduling

## Getting Started

### Prerequisites

* Java 17 or 21
* Maven 3.x
* Postman

### How to Run

1. Navigate to the project folder:
   ```bash
   cd question5-task-api
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The API will be accessible at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tasks` | Get the full task list |
| GET | `/api/tasks/{id}` | Get a specific task by ID |
| GET | `/api/tasks/priority/{level}` | Filter by priority (Path Variable) |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update an entire task |
| PATCH | `/api/tasks/{id}/complete` | Mark task as completed |
| DELETE | `/api/tasks/{id}` | Remove a task from the list |

## Sample Request & Response

### 1. Filter by Priority (HIGH)

**GET** `http://localhost:8080/api/tasks/priority/HIGH`

Sample Response:
```json
[
    {
        "taskId": 1,
        "title": "Database Design",
        "description": "Design schema",
        "completed": true,
        "priority": "HIGH",
        "dueDate": "2026-02-10"
    }
]
```

### 2. Mark Task as Completed

**PATCH** `http://localhost:8080/api/tasks/2/complete`

Expected Behavior: The `completed` boolean for task ID 2 is updated to `true`.

### 3. Create a New Task

**POST** `/api/tasks`

Request Body:
```json
{
    "title": "Complete Spring Boot Assignment",
    "description": "Finish all REST API questions",
    "completed": false,
    "priority": "HIGH",
    "dueDate": "2026-02-20"
}
```

### 4. Filter by Completion Status

**GET** `/api/tasks/status?completed=false`

Expected Behavior: Returns all tasks that are not yet completed.

## Project Structure

* **Model Package**: `com.afanyu.question5_task_api.modal.task`
* **Controller Package**: `com.afanyu.question5_task_api.controller.task`
