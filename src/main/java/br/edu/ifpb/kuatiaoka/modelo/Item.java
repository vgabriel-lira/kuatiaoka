package br.edu.ifpb.kuatiaoka.modelo;

public abstract class Item {
    private String titulo;
    private String editora;
    private int ano;
    private boolean estaEmprestado; // nome q o Gerenciador procura

    public Item(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.estaEmprestado = false;
    }

    public String getTitulo() { return titulo; }
    
    public boolean isEmprestado() { return estaEmprestado; }

    public void setEstaEmprestado(boolean status) {
        this.estaEmprestado = status;
    }
}