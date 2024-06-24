FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY commons.jar /app/commons/commons.jar

RUN mvn install:install-file -Dfile=/app/commons/commons.jar -DgroupId=org.ooka -DartifactId=commons -Dversion=1.0-SNAPSHOT -Dpackaging=jar
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/ms-mounting-systems.jar .

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "ms-mounting-systems.jar"]
