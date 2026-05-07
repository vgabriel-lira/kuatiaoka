package br.edu.ifpb.kuatiaoka.modelo;

import java.util.List;
<<<<<<< HEAD

public class CD extends Item {
    private String artista;
    private List<String> listaFaixas; 

=======

public class CD extends Item {
    
    // ========== ATRIBUTOS ==========
    private String artista;
    private List<String> listaFaixas;
    
    // ========== CONSTRUTOR ==========
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    public CD(String titulo, String editora, String artista, List<String> listaFaixas) {
        super(titulo, editora);
        this.artista = artista;
        this.listaFaixas = listaFaixas;
    }
<<<<<<< HEAD

=======
    
    // ========== MÉTODOS ==========
    
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    @Override
    public String toString() {
        return "CD: " + getTitulo() + " | Artista: " + artista + " | Faixas: " + listaFaixas.size();
    }
}