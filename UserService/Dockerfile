FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/UserService-0.0.1-SNAPSHOT.jar /app/UserService-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]