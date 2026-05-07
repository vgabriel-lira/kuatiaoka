package br.edu.ifpb.kuatiaoka.modelo;

// O Livro herda tudo o que o Item tem (titulo, ano, etc)
public class Livro extends Item {
    private String codigoIsbn;

    public Livro(String titulo, String editora, int ano, String codigoIsbn) {
        // O "super" envia as informações lá pra classe Item organizar
        super(titulo, editora, ano);
        this.codigoIsbn = codigoIsbn;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }
}