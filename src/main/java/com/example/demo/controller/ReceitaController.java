package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Receita;
import com.example.demo.repository.ReceitaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;

    public ReceitaController(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarTodas() {
        return ResponseEntity.ok(receitaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarPorId(@PathVariable String id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        return receita.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Receita>> listarPorPaciente(@PathVariable String pacienteId) {
        return ResponseEntity.ok(receitaRepository.findByPacienteId(pacienteId));
    }

    @GetMapping("/nutricionista/{nutricionistaId}")
    public ResponseEntity<List<Receita>> listarPorNutricionista(@PathVariable String nutricionistaId) {
        return ResponseEntity.ok(receitaRepository.findByNutricionistaId(nutricionistaId));
    }

    @PostMapping
    public ResponseEntity<Receita> criar(@RequestBody Receita receita) {
        Receita nova = receitaRepository.save(receita);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable String id, @RequestBody Receita receitaAtualizada) {
        if (!receitaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        receitaAtualizada.setId(id);
        Receita atualizada = receitaRepository.save(receitaAtualizada);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        if (!receitaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        receitaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
