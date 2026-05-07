package br.edu.ifpb.kuatiaoka.modelo;

public class Livro extends Item {
    private String isbn;
    private String autor;
    private int ano;
    private int edicao;
    private String genero;
    private int paginas;
    private String sinopse;

    public Livro(String titulo, String editora, String isbn, String autor, int ano, int edicao, String genero, int paginas, String sinopse) {
        super(titulo, editora); // Passa apenas o basico para a classe pai
        this.isbn = isbn;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.genero = genero;
        this.paginas = paginas;
        this.sinopse = sinopse;
    }

    public String getIsbn() { return isbn; }
    
    @Override
    public String toString() {
        return "Livro: " + getTitulo() + " | Autor: " + autor + " | ISBN: " + isbn;
    }
}