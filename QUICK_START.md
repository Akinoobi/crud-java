# Quick Start Guide

This guide will help you get the CRUD Java application running in minutes.

## Prerequisites Check

First, verify you have the required software:

```bash
# Check Java version (should be 17 or higher)
java -version

# Check Maven version (should be 3.6 or higher)
mvn -version
```

## Step 1: Build the Application

```bash
mvn clean install
```

## Step 2: Run the Application

```bash
mvn spring-boot:run
```

You should see output like:

```
Started CrudJavaApplication in X.XXX seconds
Sample data initialized successfully!
Created 5 users
```

## Step 3: Test the Application

### Option A: Use the Web Interface

Open your browser and go to: `http://localhost:8080`

This will show you a web interface where you can test all API endpoints.

### Option B: Use curl Commands

#### Get all users:

```bash
curl http://localhost:8080/api/users
```

#### Create a new user:

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Test User",
    "email": "test@example.com",
    "password": "password123",
    "phone": "+1234567890"
  }'
```

#### Get user by ID (replace 1 with actual ID):

```bash
curl http://localhost:8080/api/users/1
```

#### Update user (replace 1 with actual ID):

```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Name",
    "email": "updated@example.com",
    "password": "newpassword123",
    "phone": "+1234567890"
  }'
```

#### Delete user (replace 1 with actual ID):

```bash
curl -X DELETE http://localhost:8080/api/users/1
```

### Option C: Use H2 Database Console

Open your browser and go to: `http://localhost:8080/h2-console`

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## Step 4: Verify Everything Works

1. The application should be running on `http://localhost:8080`
2. The web interface should be accessible
3. The H2 console should be accessible
4. API endpoints should respond correctly

## Troubleshooting

### Port 8080 is already in use

Change the port in `src/main/resources/application.properties`:

```
server.port=8081
```

### Java version issues

Make sure you have Java 17+ installed and JAVA_HOME is set correctly.

### Maven issues

Try running `mvn clean` and then `mvn install` again.

## Next Steps

- Read the full [README.md](README.md) for detailed documentation
- Explore the API endpoints
- Try different search and filter operations
- Check out the sample data in the H2 console

## Sample Data

The application comes with 5 pre-created users:

1. John Doe (john.doe@example.com)
2. Jane Smith (jane.smith@example.com)
3. Bob Johnson (bob.johnson@company.com)
4. Alice Brown (alice.brown@test.org)
5. Charlie Wilson (charlie.wilson@demo.net)

You can use these to test the API endpoints immediately.



