package br.edu.ifpb.kuatiaoka.modelo;

public class CD extends Item {
    private String artista;
    private String listaFaixas;

    public CD(String titulo, String editora, String artista, String listaFaixas) {
        super(titulo, editora);
        this.artista = artista;
        this.listaFaixas = listaFaixas;
    }

    // pro cd pedia artista e lista de musicas. coloquei a lista como String msm pra gente n se complicar com arrays agora

    public String getArtista() { return artista; }
    public String getListaFaixas() { return listaFaixas; }
}