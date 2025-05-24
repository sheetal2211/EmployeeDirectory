# Use an official OpenJDK runtime as a base image for running the app
FROM openjdk:21-jdk

COPY ./app/target/employee-directory.jar .

# Expose the application port (change if necessary)
EXPOSE 8080:8080

# Run the application
ENTRYPOINT ["java", "-jar", "employee-directory.jar"]

