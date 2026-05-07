package br.edu.ifpb.kuatiaoka.modelo;

import java.util.List;

public class CD extends Item {
    
    // ========== ATRIBUTOS ==========
    private String artista;
    private List<String> listaFaixas;
    
    // ========== CONSTRUTOR ==========
    public CD(String titulo, String editora, String artista, List<String> listaFaixas) {
        super(titulo, editora);
        this.artista = artista;
        this.listaFaixas = listaFaixas;
    }
    
    // ========== MÉTODOS ==========
    
    @Override
    public String toString() {
        return "CD: " + getTitulo() + " | Artista: " + artista + " | Faixas: " + listaFaixas.size();
    }
}