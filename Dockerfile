FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar region-0.0.1.jar
# EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/region-0.0.1.jar"]