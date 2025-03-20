FROM gradle:8.3-jdk17 AS builder
WORKDIR /app

COPY build.gradle gradlew settings.gradle ./
COPY gradle gradle
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENV LANG=ja_JP.UTF-8

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
