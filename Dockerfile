# Start with a base image containing Java runtime
FROM openjdk:26-ea-21-jdk-slim

# Information about who maintains the image
MAINTAINER dzrrcreations-RReis

# Add the application's jar to the container
COPY target/spring-app-0.0.1-SNAPSHOT.jar spring-app-mvc-rest.jar

# Run the jar file (execute the application)
ENTRYPOINT ["java","-jar","spring-app-mvc-rest.jar"]