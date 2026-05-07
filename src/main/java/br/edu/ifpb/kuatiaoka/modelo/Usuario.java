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

    // esses dois aqui como abstratos pq cada tipo de usuario vai ter seu proprio prazo e valor de multa
    public abstract int getPrazoParaItem(Item item);
    public abstract double getValorMultaDiaria();

    // aqui os getters e setters  
    public String getStatusMulta() { return statusMulta; }
    public void setStatusMulta(String statusMulta) { this.statusMulta = statusMulta; }
    public double getSaldoMulta() { return saldoMulta; }
    public void setSaldoMulta(double saldoMulta) { this.saldoMulta = saldoMulta; }
    public String getMatricula() {return matricula; }
    public String getNome() { return nome; }
    public int getMaxLivros() { return maxLivros; }
    public int getLivrosAtuais() { return livrosAtuais; }
    public void setLivrosAtuais(int livrosAtuais) { this.livrosAtuais = livrosAtuais; }
}