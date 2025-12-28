FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/ConfigServer-0.0.1-SNAPSHOT.jar  /app/ConfigServer-0.0.1-SNAPSHOT.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","ConfigServer-0.0.1-SNAPSHOT.jar"]