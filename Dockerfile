# Openjdk as the build image
FROM maven:3.8-openjdk-17-slim AS build

# The working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the Maven project
RUN mvn clean install

# Intermediate container for copying the built artifact
FROM openjdk:17-jdk-slim AS final

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/inventory-service-0.0.1-SNAPSHOT.jar .

# Expose the application port
EXPOSE 8081

# Set the entry point to run the application
CMD ["java", "-jar", "inventory-service-0.0.1-SNAPSHOT.jar"]