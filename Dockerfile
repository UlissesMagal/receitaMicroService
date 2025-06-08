# Fase de build (Linux)
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copia os arquivos do Maven Wrapper
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Torna o mvnw executável (Linux)
RUN chmod +x mvnw

# Baixa dependências e faz o build
RUN ./mvnw dependency:go-offline
RUN ./mvnw package -DskipTests

# Fase de execução (Linux)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]