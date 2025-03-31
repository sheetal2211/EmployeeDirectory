FROM openjdk:21-jdk

EXPOSE 8080

COPY ./bootstrap/target/employee-directory.jar .
WORKDIR /app

ENTRYPOINT ["java", "-jar", "employee-directory.jar"]
