Spring Boot REST API Project
This project is a Spring Boot-based REST API designed to manage users, projects, roles, and related information with a focus on security, scalability, and maintainability. It uses JWT-based authentication, role-based access control, and efficient data handling practices such as filtering, pagination, and caching.
________________________________________
Features
•	Authentication: JWT-based login and registration.
•	Authorization: Role-based access control (ADMIN, USER).
•	CRUD Operations: For users, projects, and statuses.
•	Filtering and Pagination: Efficient data retrieval.
•	Caching: Improves performance for GET requests.
•	Error Handling: Meaningful HTTP status codes and error messages.
________________________________________
Technologies Used
•	Java 17
•	Spring Boot 3.x
•	Spring Security for authentication and authorization
•	JWT (JSON Web Token) for secure endpoints
•	Spring Data JPA for database operations
•	H2 Database for testing (or replace with MySQL/PostgreSQL)
•	Maven for dependency management
•	BCrypt for password encryption
________________________________________
Getting Started
Prerequisites
•	Java 17 or higher
•	Maven
•	IDE (IntelliJ, Eclipse, etc.)
Installation
1.	Clone the repository: git clone https://github.com/AidaDaniyarova/spring-boot-demo.git
3.	Navigate to the project directory: cd spring-boot-demo
5.	Install dependencies: mvn clean install
7.	Run the application: mvn spring-boot:run
________________________________________
Database Configuration
The default configuration uses an H2 in-memory database. To switch to MySQL or PostgreSQL, update the application.properties file:
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
________________________________________
API Endpoints
1. Authentication
•	Login:
POST /api/auth/login
Request:
•	{
•	  "email": "user@example.com",
•	  "password": "password"
•	}
Response: JWT token or 401 Unauthorized.
•	Register:
POST /api/auth/register
Request:
•	{
•	  "email": "user@example.com",
•	  "password": "password",
•	  "firstName": "John",
•	  "lastName": "Doe",
•	  "roles": ["USER"]
•	}
Response: 201 Created or 400 Bad Request.
________________________________________
2. User Management
•	Get All Users:
GET /api/users
o	Filters: ?role=admin
o	Pagination: ?page=0&size=10
o	Response: List of users.
•	Get User by ID:
GET /api/users/{id} — Returns user or 404 Not Found.
•	Create User (Admin):
POST /api/users
Response: 201 Created.
•	Update User:
PUT /api/users/{id} — Returns updated user or 404 Not Found.
•	Delete User (Admin):
DELETE /api/users/{id} — 204 No Content or 404 Not Found.
________________________________________
3. Project Management
•	Get All Projects:
GET /api/projects
o	Filters: ?status=active
o	Pagination: ?page=0&size=10
o	Response: List of projects.
•	Get Project by ID:
GET /api/projects/{id} — Returns project or 404 Not Found.
•	Create Project:
POST /api/projects — Requires valid JWT.
•	Update Project:
PUT /api/projects/{id} — Updates or 404 Not Found.
•	Delete Project:
DELETE /api/projects/{id} — 204 No Content or 404 Not Found.
________________________________________
4. Status Management
•	Get All Statuses:
GET /api/statuses
•	Create Status (Admin):
POST /api/statuses — Requires ADMIN role.
________________________________________
Security
•	Authentication: JWT tokens.
•	Password Encryption: BCrypt.
•	Role-Based Access: ADMIN, USER roles.
________________________________________
Caching Strategy
•	Enabled for: 
o	GET /api/projects
o	GET /api/statuses
•	Cache Control: 
o	max-age=60
o	Uses ETag for validation.
________________________________________
Error Handling and Status Codes
•	200 OK — Successful retrieval.
•	201 Created — For POST.
•	204 No Content — For DELETE.
•	400 Bad Request — Validation errors.
•	401 Unauthorized — Invalid JWT.
•	403 Forbidden — Unauthorized access.
•	404 Not Found — Non-existent resources.
•	500 Internal Server Error — Unexpected errors.
________________________________________
Testing
Run tests using Maven:
mvn test
________________________________________
Future Enhancements
•	Implement HATEOAS for discoverability.
•	Add more roles and granular permissions.
•	Integrate Swagger for API documentation.
