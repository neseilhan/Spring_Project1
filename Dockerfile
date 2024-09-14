# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the pom.xml file to the container
COPY pom.xml /app/

# Copy the source code to the container
COPY src /app/src

# Run Maven to build the project
RUN mvn install

# Copy the packaged JAR file into the container
COPY target/spring-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
