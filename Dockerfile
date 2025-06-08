# Usando uma imagem base do OpenJDK para Windows
FROM eclipse-temurin:17-jdk-windowsservercore-ltsc2022 AS build

# Definindo o diretório de trabalho (sintaxe do Windows)
WORKDIR C:\\app

# Copiando o Maven Wrapper e o pom.xml
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Baixando as dependências Maven (usando o wrapper do Windows)
RUN mvnw.cmd dependency:go-offline

# Copiando o restante do código-fonte
COPY src src

# Construindo a aplicação
RUN mvnw.cmd package -DskipTests

# Fase 2: Imagem runtime
FROM eclipse-temurin:17-jre-windowsservercore-ltsc2022

# Definindo o diretório de trabalho
WORKDIR C:\\app

# Copiando o arquivo JAR gerado
COPY --from=build C:\\app\\target\\demo-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]