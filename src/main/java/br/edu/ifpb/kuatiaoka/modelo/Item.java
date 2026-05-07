package br.edu.ifpb.kuatiaoka.modelo;

import java.time.LocalDate;

public abstract class Item {
    private String titulo;
    private String editora;
    // string c status aceitos de: "DISPONIVEL", "EMPRESTADO", "RESERVADO", "MANUTENCAO"
    private String status; 
    private LocalDate dataDevolucaoPrevista;

    public Item(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
        this.status = "DISPONIVEL"; // qlqr coisa nova vai já nascer como disponivel
    }

    public String getTitulo() { return titulo; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // a data nula ate alguem pegar algum livro
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(LocalDate data) { this.dataDevolucaoPrevista = data; }
}