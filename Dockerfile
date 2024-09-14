# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

COPY src /workdir/server/src
RUN mvn install

# Copy the packaged JAR file into the container
COPY target/spring-0.0.1-SNAPSHOT.jar app.jar


#RUN apt-get update && apt-get install -y maven

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
