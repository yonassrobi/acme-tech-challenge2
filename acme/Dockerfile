FROM openjdk:18-alpine
MAINTAINER com.coforma
COPY target/acme-0.0.1-SNAPSHOT.jar acme-server-1.0.0.jar
COPY target/.env.deployment.properties acme.application.properties
ENTRYPOINT ["java","-jar","/acme-server-1.0.0.jar", "--spring.config.location=acme.application.properties"]