package br.edu.ifpb.kuatiaoka.modelo;

public class CD extends Item {
    private String artista;
    private String listaFaixas;

    public CD(String titulo, String editora, String artista, String listaFaixas) {
        super(titulo, editora);
        this.artista = artista;
        this.listaFaixas = listaFaixas;
    }
}