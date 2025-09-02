# CRUD Java Application

A complete CRUD (Create, Read, Update, Delete) Java application built with Spring Boot, featuring a RESTful API for user management.

## Features

- **RESTful API**: Complete CRUD operations for User entities
- **Database Integration**: H2 in-memory database with JPA/Hibernate
- **Data Validation**: Input validation using Bean Validation
- **Error Handling**: Comprehensive error handling and responses
- **Search Functionality**: Search users by name, email domain, and creation date
- **Sample Data**: Pre-populated with sample users for testing
- **H2 Console**: Web-based database console for data inspection

## Technology Stack

- **Java 17+** (JDK 24 tested)
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database**
- **Maven 3.9.5** (via Maven Wrapper)
- **Bean Validation**
- **Docker** (optional)

## Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven** (optional - the project includes Maven Wrapper)

### Check Java Version

```bash
java -version
```

### Check Maven Version (if installed globally)

```bash
mvn -version
```

**Note**: This project includes Maven Wrapper (`mvnw.cmd` for Windows), so you don't need to install Maven globally.

## How to Run Locally

### 1. Clone the Repository

```bash
git clone <repository-url>
cd crud-java
```

### 2. Set Java Environment (if not in PATH)

If Java is not in your system PATH, set it manually:

```bash
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"
$env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"
```

**Note**: Adjust the path according to your Java installation location.

### 3. Build the Application

**Option A: Using Maven Wrapper (Recommended)**

```bash
# Set Java environment and build
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"; $env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"; .\mvnw.cmd clean install
```

**Option B: Using Global Maven (if installed)**

```bash
mvn clean install
```

### 4. Run the Application

**Option A: Using Maven Wrapper (Recommended)**

```bash
# Set Java environment and run
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"; $env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"; .\mvnw.cmd spring-boot:run
```

**Option B: Using Global Maven (if installed)**

```bash
mvn spring-boot:run
```

**Option C: Run the JAR file directly**

```bash
java -jar target/crud-java-1.0.0.jar
```

### 5. Verify the Application is Running

The application will start on `http://localhost:8080`

You should see output similar to:

```
Started CrudJavaApplication in X.XXX seconds
Sample data initialized successfully!
Created 5 users
```

**Quick Test**: Visit `http://localhost:8080/api/users/health` to verify the API is running.

## API Endpoints

### Base URL

```
http://localhost:8080/api/users
```

### 1. Create User (POST)

```http
POST /api/users
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "password123",
    "phone": "+1234567890"
}
```

### 2. Get All Users (GET)

```http
GET /api/users
```

### 3. Get User by ID (GET)

```http
GET /api/users/{id}
```

### 4. Get User by Email (GET)

```http
GET /api/users/email/{email}
```

### 5. Update User (PUT)

```http
PUT /api/users/{id}
Content-Type: application/json

{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "password": "newpassword123",
    "phone": "+1234567890"
}
```

### 6. Delete User (DELETE)

```http
DELETE /api/users/{id}
```

### 7. Search Users by Name (GET)

```http
GET /api/users/search?name=John
```

### 8. Get Users by Email Domain (GET)

```http
GET /api/users/domain/example.com
```

### 9. Get Users Created After Date (GET)

```http
GET /api/users/created-after?date=2024-01-01T00:00:00
```

### 10. Count Users by Name (GET)

```http
GET /api/users/count/John
```

### 11. Health Check (GET)

```http
GET /api/users/health
```

## Database Console

The application includes an H2 database console for data inspection:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## Sample Data

The application comes pre-populated with 5 sample users:

1. John Doe (john.doe@example.com)
2. Jane Smith (jane.smith@example.com)
3. Bob Johnson (bob.johnson@company.com)
4. Alice Brown (alice.brown@test.org)
5. Charlie Wilson (charlie.wilson@demo.net)

## Testing the API

### Using curl

#### Create a new user:

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Test User",
    "email": "test.user@example.com",
    "password": "testpass123",
    "phone": "+1111111111"
  }'
```

#### Get all users:

```bash
curl http://localhost:8080/api/users
```

#### Get user by ID:

```bash
curl http://localhost:8080/api/users/1
```

#### Update user:

```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Name",
    "email": "updated@example.com",
    "password": "newpass123",
    "phone": "+2222222222"
  }'
```

#### Delete user:

```bash
curl -X DELETE http://localhost:8080/api/users/1
```

### Using Postman

1. Import the API endpoints into Postman
2. Set the base URL to `http://localhost:8080/api/users`
3. Use the endpoints listed above

## Project Structure

```
crud-java/
├── mvnw.cmd                           # Maven Wrapper for Windows
├── .mvn/
│   └── wrapper/
│       ├── maven-wrapper.jar         # Maven Wrapper JAR
│       └── maven-wrapper.properties  # Maven Wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── crudjava/
│   │   │               ├── CrudJavaApplication.java
│   │   │               ├── controller/
│   │   │               │   └── UserController.java
│   │   │               ├── entity/
│   │   │               │   └── User.java
│   │   │               ├── repository/
│   │   │               │   └── UserRepository.java
│   │   │               ├── service/
│   │   │               │   └── UserService.java
│   │   │               └── config/
│   │   │                   └── DataInitializer.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── crudjava/
│                       └── CrudJavaApplicationTests.java
├── target/                            # Compiled classes and JAR
├── pom.xml                           # Maven configuration
├── Dockerfile                        # Docker configuration
└── docker-compose.yml                # Docker Compose configuration
```

## Maven Wrapper

This project includes Maven Wrapper (`mvnw.cmd`), which allows you to run Maven commands without having Maven installed globally on your system.

### Benefits:

- **No global Maven installation required**
- **Consistent Maven version across environments**
- **Automatic Maven download if not present**

### Usage:

```bash
# Instead of: mvn clean install
.\mvnw.cmd clean install

# Instead of: mvn spring-boot:run
.\mvnw.cmd spring-boot:run

# Instead of: mvn test
.\mvnw.cmd test
```

## Configuration

The application configuration is in `src/main/resources/application.properties`:

- **Server Port**: 8080
- **Database**: H2 in-memory
- **JPA**: Hibernate with create-drop mode
- **H2 Console**: Enabled at `/h2-console`

## Error Handling

The API returns appropriate HTTP status codes:

- **200 OK**: Successful operation
- **201 Created**: Resource created successfully
- **400 Bad Request**: Invalid input or business rule violation
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Server error

Error responses include a JSON object with an `error` field containing the error message.

## Validation Rules

- **Name**: Required, 2-50 characters
- **Email**: Required, valid email format, unique
- **Password**: 6-100 characters
- **Phone**: Optional

## Running Tests

**Using Maven Wrapper:**

```bash
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"; $env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"; .\mvnw.cmd test
```

**Using Global Maven:**

```bash
mvn test
```

## Building for Production

**Using Maven Wrapper:**

```bash
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"; $env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"; .\mvnw.cmd clean package
```

**Using Global Maven:**

```bash
mvn clean package
```

This creates a JAR file in the `target/` directory that can be run with:

```bash
java -jar target/crud-java-1.0.0.jar
```

## Troubleshooting

### Common Issues

1. **Port 8080 already in use**:

   - Change the port in `application.properties`: `server.port=8081`

2. **Java version issues**:

   - Ensure Java 17+ is installed and JAVA_HOME is set correctly
   - If Java is not in PATH, set it manually: `$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"; $env:PATH = "C:\Program Files\Java\jdk-24\bin;$env:PATH"`

3. **Maven issues**:

   - Use the Maven Wrapper: `.\mvnw.cmd` instead of `mvn`
   - If using global Maven, run `mvn clean` and try again
   - Check Maven version: `mvn -version`

4. **Maven Wrapper issues**:
   - Ensure `mvnw.cmd` and `.mvn/wrapper/` directory exist
   - The wrapper will automatically download Maven if not present

### Logs

The application logs are displayed in the console. For more detailed logging, check the `application.properties` file.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is open source and available under the MIT License.
