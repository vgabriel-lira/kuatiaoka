package br.edu.ifpb.kuatiaoka.modelo;

public class Livro extends Item {
    private String isbn;
    private String autor;
    private int anoPublicacao;
    private int edicao;
    private String genero;
    private int numPaginas;
    private String sinopse;

    public Livro(String titulo, String editora, String isbn, String autor, int ano, int edicao, String genero, int paginas, String sinopse) {
        super(titulo, editora);
        this.isbn = isbn;
        this.autor = autor;
        this.anoPublicacao = ano;
        this.edicao = edicao;
        this.genero = genero;
        this.numPaginas = paginas;
        this.sinopse = sinopse;
    }
    
    // getters se precisar mostrar os detalhes depois
    public String getIsbn() { return isbn; }
}