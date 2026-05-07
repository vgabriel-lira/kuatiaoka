package br.edu.ifpb.kuatiaoka.modelo;

// "abstract" é porque ninguém cadastra um "Item" genérico, 
// ou vai ser um Livro ou uma Revista.
public abstract class Item {
    private String titulo;
    private String editora;
    private int ano;
    private boolean emprestado; // Pra gente controlar se tá na prateleira ou não

    public Item(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.emprestado = false; // Todo livro/revista novo começa disponível
    }

    // Getters pros outros arquivos conseguirem ler as informações
    public String getTitulo() { return titulo; }
    public boolean isEmprestado() { return emprestado; }

    // Setter pra gente mudar o status quando alguém pegar o livro
    public void setEmprestado(boolean status) {
        this.emprestado = status;
    }
}