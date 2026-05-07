package br.edu.ifpb.kuatiaoka.modelo;

public class DVD extends Item {
    private String diretor;
    private int duracao; // em minutos
    private String classificacao;

    public DVD(String titulo, String editora, String diretor, int duracao, String classificacao) {
        super(titulo, editora);
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    // o prof pedia diretor e duracao pra dvd mas coloquei o super(titulo, editora) pq todo item precisa disso

    public String getDiretor() { return diretor; }
    public int getDuracao() { return duracao; }
    public String getClassificacao() { return classificacao; }
}