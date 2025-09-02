# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the pom.xml
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/crud-java-1.0.0.jar"]
