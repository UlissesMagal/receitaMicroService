package com.example.nutriapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class TestConnection implements CommandLineRunner {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TestConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("\n=== TESTANDO CONEXÃO COM MONGODB ATLAS ===");
            
            // 1. Verifica se o MongoTemplate foi injetado corretamente
            if (mongoTemplate == null) {
                System.err.println("Erro: MongoTemplate não foi injetado corretamente");
                return;
            }
            
            // 2. Obtém o nome do banco de dados configurado
            String dbName = mongoTemplate.getDb().getName();
            System.out.println("Banco de dados conectado: " + dbName);
            
            // 3. Lista todas as coleções
            System.out.println("\nColeções disponíveis:");
            mongoTemplate.getCollectionNames().forEach(System.out::println);
            
           
        } catch (Exception e) {
            System.err.println("\n=== ERRO NA CONEXÃO ===");
            System.err.println("Mensagem: " + e.getMessage());
            System.err.println("Causa provável: " + (e.getCause() != null ? e.getCause().getMessage() : "não especificada"));
            
            // Log mais detalhado para diagnóstico
            e.printStackTrace();
        }
    }
}