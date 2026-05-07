package br.edu.ifpb.kuatiaoka.modelo;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private int maxLivros;      // o gerenciador procura esse nome
    private int livrosAtuais;   // esse tbm

    public Usuario(String nome, String matricula, int maxLivros) {
        this.nome = nome;
        this.matricula = matricula;
        this.maxLivros = maxLivros;
        this.livrosAtuais = 0;
    }

    public String getNome() { return nome; }
    public int getMaxLivros() { return maxLivros; }
    public int getLivrosAtuais() { return livrosAtuais; }

    public void setLivrosAtuais(int quantidade) {
        this.livrosAtuais = quantidade;
    }
}