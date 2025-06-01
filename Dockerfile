FROM openjdk:21

WORKDIR /app
COPY . .

COPY target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar", "ru.ziplla.mashkov_senya_maks.MashkovSenyaMaksApplication", "--spring.config.location=src/main/resources/application.properties"]