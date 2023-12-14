FROM maven:3.9-eclipse-temurin-17 as build

COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean install -DskipTests

RUN ls -la /usr/src/app/exposition/target/
FROM openjdk:17-jdk-slim
COPY --from=build /usr/src/app/exposition/target/*.jar /app/exposition.jar
EXPOSE 12378
ENTRYPOINT ["java", "-jar", "/app/exposition.jar"]