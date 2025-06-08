package com.example.nutriapp.model;

import java.util.List;




public class Receita {

    private String id;
    private String nome;
    private String categoria;
    private int tempoPreparo;
    private List<String> ingredientes;
    private List<String> modoPreparo;
    private String nutricionistaId; 
    private String pacienteId;      
    
    // Construtores, getters e setters
    public Receita() {}
    



    
    public Receita(String nome, String categoria, int tempoPreparo, List<String> ingredientes, List<String> modoPreparo,
            String nutricionistaId, String pacienteId) {
        this.nome = nome;
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.nutricionistaId = nutricionistaId;
        this.pacienteId = pacienteId;
    }





    public String getId() {
        return id;
    }





    public void setId(String id) {
        this.id = id;
    }





    public String getNome() {
        return nome;
    }





    public void setNome(String nome) {
        this.nome = nome;
    }





    public String getCategoria() {
        return categoria;
    }





    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }





    public int getTempoPreparo() {
        return tempoPreparo;
    }





    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }





    public List<String> getIngredientes() {
        return ingredientes;
    }





    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }





    public List<String> getModoPreparo() {
        return modoPreparo;
    }





    public void setModoPreparo(List<String> modoPreparo) {
        this.modoPreparo = modoPreparo;
    }





    public String getNutricionistaId() {
        return nutricionistaId;
    }





    public void setNutricionistaId(String nutricionistaId) {
        this.nutricionistaId = nutricionistaId;
    }





    public String getPacienteId() {
        return pacienteId;
    }





    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }


    

   

    
}