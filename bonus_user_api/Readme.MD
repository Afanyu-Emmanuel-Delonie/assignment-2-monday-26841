# User Profile API (Bonus Module)

A professional-grade User Management API that implements an industry-standard Unified Response Wrapper. This ensures that all API consumers receive consistent metadata alongside their requested data.

## Features

* Response Wrapping: Every request returns an `ApiResponse<T>` object containing a success flag, status message, and the data payload
* Advanced Multi-Criteria Search: Search for users using any combination of `username`, `country`, and `age range` (min/max)
* Account Status Control: Dedicated `PATCH` endpoint to activate or deactivate user profiles
* Standardized Error Handling: Structured JSON responses for 404 and 400 errors, ensuring the client can always parse the result

## The Response Wrapper Structure

All responses follow this JSON schema:

```json
{
    "success": true, 
    "message": "Specific action message here",
    "data": { ... } 
}
```

## Getting Started

### Prerequisites

* Java 17 or 21
* Maven 3.x
* Postman

### How to Run

1. Navigate to the project folder:
   ```bash
   cd bonus-user-api
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The API will be accessible at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/users` | Register a new user |
| GET | `/api/users/search` | Advanced search (`?country=USA&minAge=18`) |
| PATCH | `/api/users/{id}/status` | Toggle user activity (`?active=true/false`) |
| GET | `/api/users/{username}` | Retrieve profile by username |
| DELETE | `/api/users/{id}` | Permanently remove a user |

## Sample Request & Response

### 1. Register a New User

**POST** `/api/users`

Request Body:
```json
{
    "username": "john_doe",
    "email": "john@example.com",
    "fullName": "John Doe",
    "age": 25,
    "country": "USA",
    "active": true
}
```

Response:
```json
{
    "success": true,
    "message": "User registered successfully",
    "data": {
        "userId": 1,
        "username": "john_doe",
        "email": "john@example.com",
        "fullName": "John Doe",
        "age": 25,
        "country": "USA",
        "active": true
    }
}
```

### 2. Advanced Search (Country & Age)

**GET** `http://localhost:8080/api/users/search?country=Canada&minAge=30`

Sample Response:
```json
{
    "success": true,
    "message": "Search completed successfully",
    "data": [
        {
            "userId": 2,
            "username": "jane_admin",
            "email": "jane@example.com",
            "fullName": "Jane Smith",
            "age": 32,
            "country": "Canada",
            "active": true
        }
    ]
}
```

### 3. Activate User

**PATCH** `http://localhost:8080/api/users/1/status?active=true`

Expected Behavior: Returns the updated user profile wrapped in the success response.

Response:
```json
{
    "success": true,
    "message": "User status updated successfully",
    "data": {
        "userId": 1,
        "username": "john_doe",
        "email": "john@example.com",
        "fullName": "John Doe",
        "age": 25,
        "country": "USA",
        "active": true
    }
}
```

### 4. Get User by Username

**GET** `http://localhost:8080/api/users/john_doe`

Response:
```json
{
    "success": true,
    "message": "User retrieved successfully",
    "data": {
        "userId": 1,
        "username": "john_doe",
        "email": "john@example.com",
        "fullName": "John Doe",
        "age": 25,
        "country": "USA",
        "active": true
    }
}
```

### 5. Error Response Example

**GET** `http://localhost:8080/api/users/nonexistent_user`

Response:
```json
{
    "success": false,
    "message": "User not found",
    "data": null
}
```

## Key Implementation Details

### ApiResponse Wrapper Class

The `ApiResponse<T>` class provides a standardized response structure for all endpoints:

```java
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    
    // Constructors, getters, and setters
}
```

### Benefits of Response Wrapping

1. **Consistency**: All responses follow the same structure
2. **Error Handling**: Clients can always check the `success` flag before parsing data
3. **Debugging**: The `message` field provides context for both successful and failed requests
4. **Type Safety**: Generic type `T` allows for flexible data payloads while maintaining structure

## Project Structure

* **Model Package**: `com.afanyu.bonus_user_api.modal.user`
* **Controller Package**: `com.afanyu.bonus_user_api.controller.user`
* **Response Wrapper**: `com.afanyu.bonus_user_api.response.ApiResponse`

## Advanced Search Parameters

The search endpoint supports multiple query parameters that can be combined:

| Parameter | Type | Description | Example |
|-----------|------|-------------|---------|
| `username` | String | Partial username match | `?username=john` |
| `country` | String | Exact country match | `?country=USA` |
| `minAge` | Integer | Minimum age filter | `?minAge=18` |
| `maxAge` | Integer | Maximum age filter | `?maxAge=65` |

**Combined Example:**
```
GET /api/users/search?country=USA&minAge=20&maxAge=30
```

