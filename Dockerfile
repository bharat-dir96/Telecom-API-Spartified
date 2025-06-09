# Use Eclipse Temurin Java 21 JDK as base image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/telecomApi-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

# Set environment variable for Java (optional but good practice)
ENV JAVA_OPTS=""

# Run the jar file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
