# Tryout Github Actions
.github > workflows > build-test-app-workflow.yml

# Tryout openapi

# Dockerfile

#### Run command in terminal to build an image
```
docker build -t sheetal2211/demo-app:latest .
```

#### Run command in terminal to run the image
```
docker run -p 8080:8080 sheetal2211/demo-app:latest
```

Alternatively you can run the image from Docker Hub
Click on images > run > in optional settings pass port as 8080 and run
You will see a running container in containers

#### Application is UP
Your application is running on http://localhost:8080

## CI/CD pipeline
