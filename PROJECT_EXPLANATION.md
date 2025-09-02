# CRUD Java Project Explanation

## What is this project?

This is a **Complete CRUD (Create, Read, Update, Delete) Java Application** built with Spring Boot. It's a web application that manages user data through a RESTful API, allowing you to perform all basic database operations on user records.

## 🎯 **Project Purpose**

The main goal of this project is to demonstrate:

- How to build a complete web application with Spring Boot
- How to implement RESTful APIs for data management
- How to work with databases using JPA/Hibernate
- How to handle user input validation and error handling
- How to structure a professional Java application

## 🏗️ **How the Application Works**

### 1. **User Interface**

- **Web Page**: When you visit `http://localhost:8080`, you see a simple HTML form
- **Purpose**: This form lets you test all the API functions without needing special tools
- **Features**: You can create, view, update, and delete users directly from your browser

### 2. **API Endpoints**

The application provides these web services:

#### Basic CRUD Operations:

- **Create User**: `POST /api/users` - Add a new user to the database
- **Read Users**: `GET /api/users` - Get all users or a specific user by ID
- **Update User**: `PUT /api/users/{id}` - Modify an existing user's information
- **Delete User**: `DELETE /api/users/{id}` - Remove a user from the database

#### Advanced Features:

- **Search by Name**: `GET /api/users/search?name=John` - Find users with "John" in their name
- **Filter by Email Domain**: `GET /api/users/domain/example.com` - Get all users from a specific email domain
- **Filter by Date**: `GET /api/users/created-after?date=2024-01-01` - Find users created after a specific date
- **Count Users**: `GET /api/users/count/John` - Count how many users have "John" in their name
- **Health Check**: `GET /api/users/health` - Check if the application is running properly

### 3. **Database**

- **Type**: H2 Database (in-memory)
- **Purpose**: Stores all user information
- **Access**: You can view the database directly at `http://localhost:8080/h2-console`
- **Sample Data**: The app comes with 5 pre-loaded users for testing

## 📁 **Project Structure Explained**

```
crud-java/
├── src/main/java/com/example/crudjava/
│   ├── CrudJavaApplication.java          # Main application startup
│   ├── controller/UserController.java    # Handles web requests
│   ├── entity/User.java                  # Defines user data structure
│   ├── repository/UserRepository.java    # Database operations
│   ├── service/UserService.java          # Business logic
│   └── config/DataInitializer.java       # Loads sample data
├── src/main/resources/
│   ├── application.properties           # Configuration settings
│   └── static/index.html                 # Web interface
├── pom.xml                               # Project dependencies
├── Dockerfile                            # Container configuration
└── docker-compose.yml                    # Multi-container setup
```

### **What Each File Does:**

#### **Java Files:**

- **`CrudJavaApplication.java`**: The main class that starts the Spring Boot application
- **`UserController.java`**: Receives HTTP requests and returns responses (like a waiter taking orders)
- **`User.java`**: Defines what a user looks like (name, email, password, etc.)
- **`UserRepository.java`**: Handles all database operations (save, find, delete)
- **`UserService.java`**: Contains business rules and logic
- **`DataInitializer.java`**: Automatically creates sample users when the app starts

#### **Configuration Files:**

- **`application.properties`**: Settings like database connection, server port, etc.
- **`pom.xml`**: Lists all the libraries and tools the project needs
- **`Dockerfile`**: Instructions for running the app in a container
- **`docker-compose.yml`**: Setup for running multiple services together

## 🔧 **How Data Flows Through the Application**

### **Creating a User:**

1. **User fills out form** on the web page
2. **Browser sends POST request** to `/api/users`
3. **UserController** receives the request
4. **UserService** validates the data (checks email format, required fields, etc.)
5. **UserRepository** saves the user to the database
6. **Response** is sent back to the browser with success/error message

### **Reading Users:**

1. **User visits** `/api/users` or clicks "Get All Users"
2. **UserController** receives GET request
3. **UserRepository** fetches data from database
4. **UserService** processes the data (if needed)
5. **Response** returns list of users as JSON

### **Updating a User:**

1. **User modifies** existing user data
2. **PUT request** sent to `/api/users/{id}`
3. **UserController** finds the user by ID
4. **UserService** validates new data
5. **UserRepository** updates the database
6. **Response** confirms the update

### **Deleting a User:**

1. **User clicks delete** or sends DELETE request
2. **UserController** receives DELETE request
3. **UserRepository** removes user from database
4. **Response** confirms deletion

## 🛡️ **Data Validation & Error Handling**

### **What Gets Validated:**

- **Name**: Must be 2-50 characters long
- **Email**: Must be a valid email format and unique
- **Password**: Must be 6-100 characters
- **Phone**: Optional, but if provided must be valid

### **Error Responses:**

- **400 Bad Request**: Invalid data (wrong email format, missing name, etc.)
- **404 Not Found**: User doesn't exist
- **500 Internal Server Error**: Something went wrong on the server

## 🎮 **How to Use the Application**

### **Method 1: Web Interface (Easiest)**

1. Start the application: `mvn spring-boot:run`
2. Open browser to `http://localhost:8080`
3. Use the forms to create, view, update, and delete users

### **Method 2: API Testing (For Developers)**

1. Use tools like Postman or curl
2. Send HTTP requests to the API endpoints
3. Get JSON responses back

### **Method 3: Database Console**

1. Visit `http://localhost:8080/h2-console`
2. Login with username: `sa`, password: `password`
3. View and modify data directly in the database

## 💻 **NetBeans IDE Setup Guide**

### **Prerequisites for NetBeans:**

1. **Java JDK 17 or higher**

   - Download from: https://adoptium.net/ or https://www.oracle.com/java/technologies/downloads/
   - Install and set JAVA_HOME environment variable

2. **NetBeans IDE**
   - Download NetBeans 21 or higher from: https://netbeans.apache.org/download/
   - Choose "Java SE" or "All" bundle during installation

### **Opening the Project in NetBeans:**

#### **Step 1: Import the Project**

1. Open NetBeans IDE
2. Go to **File → Open Project**
3. Navigate to your `crud-java` folder
4. Select the folder and click **Open**
5. NetBeans will automatically detect it as a Maven project

#### **Step 2: Verify Project Setup**

1. In the **Projects** tab, you should see:
   - `crud-java` project with Maven icon
   - `Dependencies` folder with all required libraries
   - `Source Packages` with your Java files

#### **Step 3: Configure Java Version**

1. Right-click on the project name
2. Select **Properties**
3. Go to **Sources** category
4. Ensure **Source/Binary Format** is set to **JDK 17**
5. Click **OK**

### **Running the Application in NetBeans:**

#### **Method 1: Using NetBeans Run Button**

1. Right-click on `CrudJavaApplication.java` in the Projects tab
2. Select **Run File**
3. The application will start and show output in the Output window
4. You'll see: `Started CrudJavaApplication in X.XXX seconds`

#### **Method 2: Using Maven Commands**

1. Right-click on the project name
2. Select **Run Maven → Goals**
3. Type: `spring-boot:run`
4. Click **OK**

#### **Method 3: Using Terminal in NetBeans**

1. Go to **Window → IDE Tools → Terminal**
2. Navigate to your project directory
3. Run: `mvn spring-boot:run`

### **Testing the Application:**

1. **Open Browser**: Go to `http://localhost:8080`
2. **Test Web Interface**: Use the forms to create, view, update, and delete users
3. **Test API**: Visit `http://localhost:8080/api/users` to see JSON response
4. **Database Console**: Visit `http://localhost:8080/h2-console`

### **Debugging in NetBeans:**

#### **Setting Breakpoints:**

1. Open any Java file (e.g., `UserController.java`)
2. Click in the left margin next to a line number to set a breakpoint
3. Run the application in debug mode: Right-click project → **Debug**

#### **Debug Mode:**

1. Right-click on the project
2. Select **Debug** instead of **Run**
3. The application will pause at breakpoints
4. Use **F5** to step through code, **F8** to continue

### **Common NetBeans Issues & Solutions:**

#### **Issue 1: Maven Dependencies Not Downloaded**

- **Solution**: Right-click project → **Clean and Build**
- **Alternative**: Right-click project → **Run Maven → Reload Project**

#### **Issue 2: Java Version Mismatch**

- **Solution**: Right-click project → **Properties → Sources → Source/Binary Format → JDK 17**

#### **Issue 3: Port 8080 Already in Use**

- **Solution**:
  1. Open `application.properties`
  2. Add: `server.port=8081`
  3. Restart the application
  4. Access at `http://localhost:8081`

#### **Issue 4: Project Not Recognized as Maven Project**

- **Solution**:
  1. Close NetBeans
  2. Delete `.netbeans` folder in project directory
  3. Reopen NetBeans and import project again

### **NetBeans Features for This Project:**

#### **Code Completion:**

- Type `@` and see available annotations
- Type `@RestController` and press **Ctrl+Space** for auto-completion

#### **Navigation:**

- **Ctrl+Click** on any class name to go to its definition
- **Ctrl+Shift+F** to search across all files
- **Ctrl+R** to find and replace

#### **Project Structure:**

- **Projects** tab shows your project hierarchy
- **Files** tab shows actual file system
- **Services** tab shows database connections

#### **Database Integration:**

1. Go to **Services** tab
2. Right-click **Databases**
3. Select **New Connection**
4. Choose **H2 (Embedded)**
5. Set JDBC URL: `jdbc:h2:mem:testdb`
6. Username: `sa`, Password: `password`

### **Building and Packaging:**

#### **Create JAR File:**

1. Right-click project → **Run Maven → Goals**
2. Type: `clean package`
3. Find the JAR in `target/crud-java-1.0.0.jar`

#### **Run JAR File:**

1. Open Terminal in NetBeans
2. Navigate to `target` folder
3. Run: `java -jar crud-java-1.0.0.jar`

## 🚀 **Why This Project is Useful**

### **For Learning:**

- **Spring Boot**: Modern Java framework
- **REST APIs**: Industry standard for web services
- **Database Operations**: How to work with data
- **Error Handling**: Professional error management
- **Testing**: How to test web applications

### **For Real Projects:**

- **Foundation**: Can be extended for real applications
- **Best Practices**: Follows industry standards
- **Scalable**: Easy to add more features
- **Production Ready**: Includes monitoring and health checks

## 🔮 **What You Can Do Next**

### **Add More Features:**

- **Authentication**: Login/logout system
- **More Entities**: Products, orders, categories
- **File Upload**: Profile pictures, documents
- **Email Notifications**: Welcome emails, password reset
- **Advanced Search**: More filtering options

### **Improve the Application:**

- **Better UI**: More attractive web interface
- **Pagination**: Handle large lists of users
- **Caching**: Improve performance
- **Logging**: Better tracking of user actions
- **Security**: Password encryption, input sanitization

## 📚 **Key Technologies Used**

- **Java 17+**: Modern Java programming language
- **Spring Boot 3.2.0**: Application framework
- **Spring Data JPA**: Database access layer
- **H2 Database**: In-memory database
- **Maven**: Build tool and dependency management
- **Docker**: Containerization for deployment

## 🎓 **Learning Outcomes**

After working with this project, you'll understand:

- How to build web applications with Spring Boot
- How to design and implement RESTful APIs
- How to work with databases using JPA
- How to handle user input and validation
- How to structure professional Java applications
- How to deploy applications using Docker

This project serves as both a working application and a learning resource for modern Java development!
