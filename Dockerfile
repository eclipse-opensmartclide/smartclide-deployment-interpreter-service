FROM eclipse-temurin:20-alpine
VOLUME /tmp
COPY target/deployment-interpreter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar /app.jar