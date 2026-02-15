# Spring Boot RESTful API - Comprehensive Project

This repository contains a collection of RESTful APIs developed as part of a Spring Boot practical assessment. The project demonstrates a deep dive into resource management, HTTP methodology, and professional API response structuring.

## Project Directory Structure

Each question is housed in its own project folder with a strict internal package naming convention: `com.afanyu.[project_name].model.[topic]` and `com.afanyu.[project_name].controller.[topic]`.

| Module | Project Name | Key Concepts |
|--------|--------------|--------------|
| Question 1 | `question1-library-api` | Basic CRUD, List management |
| Question 2 | `question2-student-api` | Path Variables, Query Params (GPA filtering) |
| Question 3 | `question3-restaurant-api` | Boolean toggling, Category filtering |
| Question 4 | `question4-ecommerce-api` | Pagination, Price ranges, PATCH updates |
| Question 5 | `question5-task-api` | Priority-based filtering, Status tracking |
| Bonus | `bonus-user-api` | Response Wrapping, Advanced search logic |

## Technical Implementation Highlights

### 1. Unified Response Wrapper (Bonus Feature)

In the Bonus module, we transitioned from returning raw objects to a standardized `ApiResponse<T>` structure. This ensures the frontend always receives consistent metadata:

* `success`: Boolean indicator of the request outcome
* `message`: Human-readable status update
* `data`: The actual payload (User, List, etc.)

### 2. Advanced Filtering Logic

* **Range Queries**: Implemented in the E-commerce and User modules (Min/Max price and Age ranges)
* **State Management**: Using `PATCH` for partial updates to toggle availability (Restaurant) or account status (User Profile)
* **Pagination**: Logic implemented to handle large datasets efficiently in the Product catalog

### 3. Proper HTTP Semantics

We have strictly adhered to REST standards across all modules:

* `GET`: Safe retrieval of resources
* `POST`: Creation of new entries (returns `201 Created`)
* `PUT`: Full updates of existing resources
* `PATCH`: Efficient partial updates
* `DELETE`: Removal of resources (returns `204 No Content`)

## How to Run the Applications

### Prerequisites

* **Java**: Version 17 or 21
* **Build Tool**: Maven
* **Client**: Postman or Insomnia for testing

### Execution

1. Open your terminal in the root of the desired question folder
2. Build and start the service:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The server defaults to `http://localhost:8080`

## Testing & Validation

All endpoints have been validated using Postman. Individual README files within each project folder contain specific sample JSON payloads and expected response codes for detailed verification.

## Project Links

Each module has its own detailed README with specific endpoint documentation, sample requests, and response examples:

- [Question 1 - Library Book Management API](./question1-library-api/Readme.md)
- [Question 2 - Student Registration API](./question2-student-api/Readme.MD)
- [Question 3 - Restaurant Menu API](./question3-restaurant-api/Readme.MD)
- [Question 4 - E-Commerce Product API](./question4-ecommerce-api/Readme.MD)
- [Question 5 - Task Management API](./question5-task-api/Readme.MD)
- [Bonus - User Profile API](./bonus_user_api/Readme.MD)

## Submission Details

### Branch Information

This project is submitted under the branch: `restFull_api_StudentId`

### Git Commands Used

```bash
# Create branch
git checkout -b restFull_api_StudentId

# Add all files
git add .

# Commit changes
git commit -m "Complete Spring Boot REST API Assignment"

# Push to remote
git push origin restFull_api_StudentId
```

## Key Learning Outcomes

Through this comprehensive project, the following concepts were mastered:

1. **RESTful API Design Principles**
   - Proper use of HTTP methods and status codes
   - Resource-oriented URL structuring
   - Request/Response handling

2. **Spring Boot Framework**
   - Controller creation and mapping
   - Model/Entity design
   - Dependency injection

3. **Advanced API Features**
   - Query parameter filtering
   - Path variable routing
   - Pagination implementation
   - Partial updates with PATCH

4. **Professional Development Practices**
   - Code organization and package structure
   - API documentation
   - Consistent naming conventions
   - Error handling and validation

## Technologies Used

- **Framework**: Spring Boot 3.x
- **Language**: Java 17/21
- **Build Tool**: Maven
- **Testing**: Postman
- **Version Control**: Git

## License

This project is open source and available under the [MIT License](LICENSE).

---

**Developed as part of Spring Boot RESTful API Practical Assessment**
