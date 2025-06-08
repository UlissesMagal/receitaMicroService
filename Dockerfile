# Fase de build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copia os arquivos necessários
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copia o restante do código-fonte e realiza o build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Fase de execução
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia o jar gerado da fase de build
COPY --from=build /app/target/*.jar app.jar

# Define a porta que será exposta
EXPOSE 8080
ENV PORT=8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
