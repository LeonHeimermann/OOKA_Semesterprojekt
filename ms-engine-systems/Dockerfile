FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/ms-engine-systems.jar .

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "ms-engine-systems.jar"]
