FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/AI-gen-MAILService-0.0.1-SNAPSHOT.jar  /app/AI-gen-MAILService-0.0.1-SNAPSHOT.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","AI-gen-MAILService-0.0.1-SNAPSHOT.jar"]