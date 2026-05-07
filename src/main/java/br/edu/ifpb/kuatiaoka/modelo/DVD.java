package br.edu.ifpb.kuatiaoka.modelo;

public class DVD extends Item {
    private String diretor;
    private int duracao;
    private String classificacao;

    public DVD(String titulo, String editora, String diretor, int duracao, String classificacao) {
        super(titulo, editora);
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return "DVD: " + getTitulo() + " | Diretor: " + diretor + " | Duração: " + duracao + " min | Classificação: " + classificacao;
    }

    // Getters caso o professor peça para mostrar algo específico
    public String getDiretor() { return diretor; }
    public int getDuracao() { return duracao; }
    public String getClassificacao() { return classificacao; }
}