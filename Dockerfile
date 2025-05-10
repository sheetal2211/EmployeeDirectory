# Use the official Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the Maven project
RUN mvn clean package -DskipTests=true

# Use an official OpenJDK runtime as a base image for running the app
FROM openjdk:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built artifact from the Maven build stage
COPY --from=build /app/target/*.jar employee-directory.jar

# Expose the application port (change if necessary)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "employee-directory.jar"]

