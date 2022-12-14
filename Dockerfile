FROM maven:3.8-openjdk-18-slim AS builder
COPY ./acme /app/
WORKDIR /app/
RUN mvn clean install
   
FROM openjdk:18-alpine
MAINTAINER com.coforma
COPY --from=builder /app/target/acme-0.0.1-SNAPSHOT.jar acme-server-1.0.0.jar
COPY ./acme.deployment.properties acme.application.properties
ENTRYPOINT ["java","-jar","/acme-server-1.0.0.jar", "--spring.config.location=acme.application.properties"]