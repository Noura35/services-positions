

# Étape 1 : Construire l'application avec Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser OpenJDK pour exécuter l'application
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/service-positions-0.0.1-SNAPSHOT.jar /app/positions.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/positions.jar"]
