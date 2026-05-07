package br.edu.ifpb.kuatiaoka.modelo;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private int maxLivros;
    private int livrosAtuais;
    private double saldoMulta;
    private String statusMulta;

    public Usuario(String nome, String matricula, int maxLivros) {
        this.nome = nome;
        this.matricula = matricula;
        this.maxLivros = maxLivros;
        this.livrosAtuais = 0;
        this.saldoMulta = 0.0;
        this.statusMulta = "NENHUMA";
    }

    public abstract int getPrazoParaItem(Item item);
    public abstract double getValorMultaDiaria();

    // GETTERS NECESSÁRIOS
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public int getMaxLivros() { return maxLivros; }
    public int getLivrosAtuais() { return livrosAtuais; }
    public void setLivrosAtuais(int n) { this.livrosAtuais = n; }
    public String getStatusMulta() { return statusMulta; }
    public void setStatusMulta(String s) { this.statusMulta = s; }
    public double getSaldoMulta() { return saldoMulta; }
    public void setSaldoMulta(double v) { this.saldoMulta = v; }
}