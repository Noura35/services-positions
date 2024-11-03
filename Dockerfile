FROM openjdk:17-jdk

WORKDIR /app

COPY target/service-positions-0.0.1-SNAPSHOT.jar /app/positions.jar

EXPOSE 8080

CMD ["java", "-jar" ,"positions.jar"]