FROM maven:3.8.5-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -pl cloud-service -am -DskipTests --no-transfer-progress

FROM eclipse-temurin:8-jre
WORKDIR /app
COPY --from=build /app/cloud-service/target/cloud-service-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]