# Use official Java runtime
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/DigitalLibraryBookManagementSystem-1.0-SNAPSHOT.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]