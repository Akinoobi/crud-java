# Setup Guide for Windows

This guide will help you install Java and Maven on Windows to run the CRUD Java application.

## Prerequisites

- Windows 10 or higher
- Administrator privileges (for installation)
- Internet connection

## Step 1: Install Java 17

### Option A: Install OpenJDK 17 (Recommended)

1. **Download OpenJDK 17**

   - Go to: https://adoptium.net/
   - Click "Latest Release" for Eclipse Temurin JDK 17
   - Download the Windows x64 MSI installer

2. **Install OpenJDK 17**

   - Run the downloaded MSI file
   - Follow the installation wizard
   - Make sure to check "Add to PATH" during installation
   - Complete the installation

3. **Verify Installation**
   - Open a new Command Prompt or PowerShell
   - Run: `java -version`
   - You should see output like:
     ```
     openjdk version "17.0.x" 2023-xx-xx
     OpenJDK Runtime Environment Temurin-17.0.x+x (build 17.0.x+x)
     OpenJDK 64-Bit Server VM Temurin-17.0.x+x (build 17.0.x+x, mixed mode, sharing)
     ```

### Option B: Install Oracle JDK 17

1. **Download Oracle JDK 17**

   - Go to: https://www.oracle.com/java/technologies/downloads/
   - Download JDK 17 for Windows x64

2. **Install Oracle JDK 17**

   - Run the installer
   - Follow the installation wizard
   - Note the installation directory (e.g., `C:\Program Files\Java\jdk-17`)

3. **Set JAVA_HOME Environment Variable**

   - Right-click on "This PC" or "My Computer"
   - Select "Properties"
   - Click "Advanced system settings"
   - Click "Environment Variables"
   - Under "System Variables", click "New"
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-17` (or your installation path)
   - Click "OK"

4. **Add Java to PATH**

   - In the same Environment Variables window
   - Under "System Variables", find "Path" and click "Edit"
   - Click "New" and add: `%JAVA_HOME%\bin`
   - Click "OK" on all dialogs

5. **Verify Installation**
   - Open a new Command Prompt or PowerShell
   - Run: `java -version`

## Step 2: Install Maven

### Option A: Install Maven via Chocolatey (Recommended)

1. **Install Chocolatey** (if not already installed)

   - Open PowerShell as Administrator
   - Run:
     ```powershell
     Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
     ```

2. **Install Maven**

   - In the same PowerShell window, run:
     ```powershell
     choco install maven
     ```

3. **Verify Installation**
   - Open a new Command Prompt or PowerShell
   - Run: `mvn -version`

### Option B: Manual Maven Installation

1. **Download Maven**

   - Go to: https://maven.apache.org/download.cgi
   - Download the Binary zip archive (apache-maven-x.x.x-bin.zip)

2. **Extract Maven**

   - Create a directory: `C:\Program Files\Apache\maven`
   - Extract the downloaded zip to this directory
   - You should have: `C:\Program Files\Apache\maven\apache-maven-x.x.x`

3. **Set MAVEN_HOME Environment Variable**

   - Right-click on "This PC" or "My Computer"
   - Select "Properties"
   - Click "Advanced system settings"
   - Click "Environment Variables"
   - Under "System Variables", click "New"
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Program Files\Apache\maven\apache-maven-x.x.x`
   - Click "OK"

4. **Add Maven to PATH**

   - In the same Environment Variables window
   - Under "System Variables", find "Path" and click "Edit"
   - Click "New" and add: `%MAVEN_HOME%\bin`
   - Click "OK" on all dialogs

5. **Verify Installation**
   - Open a new Command Prompt or PowerShell
   - Run: `mvn -version`

## Step 3: Verify Everything is Working

1. **Open a new Command Prompt or PowerShell**

2. **Check Java version**:

   ```bash
   java -version
   ```

3. **Check Maven version**:

   ```bash
   mvn -version
   ```

4. **Navigate to your project directory**:

   ```bash
   cd C:\Users\Anya\Desktop\TestingProject\crud-java
   ```

5. **Build the project**:

   ```bash
   mvn clean install
   ```

6. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

## Troubleshooting

### Java not found

- Make sure JAVA_HOME is set correctly
- Make sure Java is in your PATH
- Try restarting your terminal/command prompt

### Maven not found

- Make sure MAVEN_HOME is set correctly
- Make sure Maven is in your PATH
- Try restarting your terminal/command prompt

### Permission issues

- Run Command Prompt or PowerShell as Administrator
- Make sure you have write permissions to the installation directories

### Port 8080 already in use

- Change the port in `src/main/resources/application.properties`:
  ```
  server.port=8081
  ```

## Alternative: Using Docker (If you have Docker installed)

If you have Docker installed, you can run the application without installing Java and Maven:

1. **Create a Dockerfile** (already included in the project)
2. **Build the Docker image**:
   ```bash
   docker build -t crud-java .
   ```
3. **Run the container**:
   ```bash
   docker run -p 8080:8080 crud-java
   ```

## Next Steps

Once you have Java and Maven installed:

1. Follow the [QUICK_START.md](QUICK_START.md) guide
2. Read the [README.md](README.md) for detailed documentation
3. Start testing the CRUD application

## Support

If you encounter any issues:

1. Check that all environment variables are set correctly
2. Restart your terminal/command prompt after installation
3. Make sure you're using the correct versions (Java 17+, Maven 3.6+)
4. Check the troubleshooting section above
