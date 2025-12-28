FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/Eureka_Server-0.0.1-SNAPSHOT.jar  /app/Eureka_Server-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","Eureka_Server-0.0.1-SNAPSHOT.jar"]