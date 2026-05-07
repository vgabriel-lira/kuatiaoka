package br.edu.ifpb.kuatiaoka.modelo;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private int limiteEmprestimo; // O prof pediu limites diferentes tipo 3, 4 ou 5
    private int totalEmprestado;  // Quantos livros o cara tá na mão agora

    public Usuario(String nome, String matricula, int limiteEmprestimo) {
        this.nome = nome;
        this.matricula = matricula;
        this.limiteEmprestimo = limiteEmprestimo;
        this.totalEmprestado = 0; // Começa com zero livros
    }

    // aqui os getters pro sistema consultar os limites
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public int getLimiteEmprestimo() { return limiteEmprestimo; }
    public int getTotalEmprestado() { return totalEmprestado; }

    // Pra gente atualizar a quantidade de livros que ele tem
    public void setTotalEmprestado(int total) {
        this.totalEmprestado = total;
    }
}