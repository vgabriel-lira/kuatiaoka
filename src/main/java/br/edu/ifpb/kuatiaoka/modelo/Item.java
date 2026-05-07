package br.edu.ifpb.kuatiaoka.modelo;

public abstract class Item {
    private String titulo;
    private String editora;
    private boolean estaEmprestado;

    public Item(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
        this.estaEmprestado = false;
    }

    public String getTitulo() { return titulo; }
    public boolean isEmprestado() { return estaEmprestado; }
    public void setEstaEmprestado(boolean status) { this.estaEmprestado = status; }
}