
FROM maven:3.9.11-eclipse-temurin-25 AS build
WORKDIR /app

# Copy Maven descriptor and source code
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:25-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
