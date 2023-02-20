FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /home/java/build
COPY . .
RUN mvn -f pom.xml clean package spring-boot:repackage

FROM openjdk:17-alpine as runtime
WORKDIR /home/java/app
COPY --from=build /home/java/build/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]