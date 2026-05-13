FROM maven:3.8.5-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -pl cloud-service -am -DskipTests

FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=build /app/cloud-service/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]