# Используем официальный Gradle образ с JDK
FROM gradle:8.5-jdk17 AS builder

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы проекта
COPY . .
# Собираем приложение
RUN gradle bootJar --no-daemon

# Второй этап — минимальный образ с JDK для запуска
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем собранный .jar из предыдущего этапа
COPY --from=builder /app/build/libs/*.jar app.jar

# Указываем команду запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
