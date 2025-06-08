# Usando uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim AS build

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo Maven Wrapper e o pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Baixando as dependências Maven
RUN ./mvnw dependency:go-offline

# Copiando o restante do código-fonte da aplicação
COPY src src

# Construindo a aplicação
RUN ./mvnw package -DskipTests

# Fase 2: Imagem runtime
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo JAR gerado
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta que a aplicação estará ouvindo
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]