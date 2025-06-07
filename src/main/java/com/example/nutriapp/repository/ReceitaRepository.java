package com.example.nutriapp.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nutriapp.model.Receita;

import java.util.List;

@Repository
public interface ReceitaRepository extends MongoRepository<Receita, String> {
    List<Receita> findByCategoria(String categoria);
    List<Receita> findByNomeContainingIgnoreCase(String nome);
     List<Receita> findByPacienteId(String pacienteId);
     List<Receita> findByNutricionistaId(String nutricionistaId);
}