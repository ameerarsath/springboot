# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/crud-0.0.1-SNAPSHOT.jar /app/crud-0.0.1-SNAPSHOT.jar

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "crud-0.0.1-SNAPSHOT.jar"]

# Expose the port the app will run on
EXPOSE 8080
