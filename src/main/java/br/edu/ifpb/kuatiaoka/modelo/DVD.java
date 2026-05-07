package br.edu.ifpb.kuatiaoka.modelo;

public class DVD extends Item {
    
    // ========== ATRIBUTOS ==========
    private String diretor;
    private int duracao; // em minutos
    private String classificacao;
    
    // ========== CONSTRUTOR ==========
    public DVD(String titulo, String editora, String diretor, int duracao, String classificacao) {
        super(titulo, editora);
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }
<<<<<<< HEAD

    public String getDiretor() { return diretor; }
    public int getDuracao() { return duracao; }
    public String getClassificacao() { return classificacao; }

=======
    
    // ========== GETTERS ==========
    
    public String getDiretor() {
        return diretor;
    }
    
    public int getDuracao() {
        return duracao;
    }
    
    public String getClassificacao() {
        return classificacao;
    }
    
    // ========== MÉTODOS ==========
    
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    @Override
    public String toString() {
        return "DVD: " + getTitulo() + " | Diretor: " + diretor + " | Duração: " + duracao + "min";
    }
}