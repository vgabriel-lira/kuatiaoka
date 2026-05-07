package br.edu.ifpb.kuatiaoka.modelo;

// aqui o livro vai herdar tudo q o Item tem (titulo, ano, e etc)
public class Livro extends Item {
    private String codigoIsbn;

    public Livro(String titulo, String editora, int ano, String codigoIsbn) {
        // aqui o super envia as informações lá pra classe Item organizar
        super(titulo, editora, ano);
        this.codigoIsbn = codigoIsbn;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }
}