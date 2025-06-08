package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Receita;

import java.util.List;

@Repository
public interface ReceitaRepository extends MongoRepository<Receita, String> {
    List<Receita> findByCategoria(String categoria);
    List<Receita> findByNomeContainingIgnoreCase(String nome);
     List<Receita> findByPacienteId(String pacienteId);
     List<Receita> findByNutricionistaId(String nutricionistaId);
}