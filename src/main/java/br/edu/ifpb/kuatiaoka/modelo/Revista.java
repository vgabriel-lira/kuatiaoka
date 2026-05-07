package br.edu.ifpb.kuatiaoka.modelo;

public class Revista extends Item {
    private String issn;
    private int volume;
    private int numero;
    private String dataPublicacao; // string msm pra facilitar digitação

    public Revista(String titulo, String editora, String issn, int volume, int numero, String data) {
        super(titulo, editora);
        this.issn = issn;
        this.volume = volume;
        this.numero = numero;
        this.dataPublicacao = data;
    }

    public String getIssn() { return issn; }
}