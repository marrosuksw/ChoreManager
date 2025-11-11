# =========================
# Build stage
# =========================
FROM gradle:8.10.0-jdk21 AS builder

# Ustawienie katalogu roboczego
WORKDIR /app

# Teraz kopiujemy resztę kodu źródłowego
COPY . .

# Tworzymy finalny jar
RUN ./gradlew bootJar --no-daemon

# =========================
# Runtime stage
# =========================
FROM eclipse-temurin:21-jdk

# Katalog roboczy w runtime
WORKDIR /app

# Kopiujemy gotowy jar z build stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Otwieramy port aplikacji
EXPOSE 8080

# Komenda startowa
ENTRYPOINT ["java", "-jar", "app.jar"]
