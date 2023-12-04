FROM adoptopenjdk/openjdk:17-jdk-alpine

EXPOSE 8080

WORKDIR /app

# добавляем jar-файл в контейнер
COPY build/libs/Authorization-service-0.0.1-SNAPSHOT.jar app.jar

# запуск приложения
CMD ["java", "-jar", "app.jar"]