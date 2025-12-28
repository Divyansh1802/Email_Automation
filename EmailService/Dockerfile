FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/EmailService-0.0.1-SNAPSHOT.jar  /app/EmailService-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","EmailService-0.0.1-SNAPSHOT.jar"]