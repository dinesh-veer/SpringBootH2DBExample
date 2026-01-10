#Multistage build

# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# 1. Copy the Maven wrapper and pom.xml
COPY pom.xml ./

# 2. Use 'mvn' (installed in the image) instead of './mvnw'
# This downloads dependencies into the image layer
RUN mvn dependency:go-offline

# 3. Now copy the source code
COPY src ./src

# 4. Build the JAR
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre
#Small image
#FROM bellsoft/liberica-openjre-alpine:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]