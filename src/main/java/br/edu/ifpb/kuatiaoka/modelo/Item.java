package br.edu.ifpb.kuatiaoka.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    private String titulo;
    private String editora;
    private String status; // DISPONIVEL, EMPRESTADO, RESERVADO, MANUTENCAO
    private LocalDate dataDevolucaoPrevista;
    private List<String> historico = new ArrayList<>(); // historico

    public Item(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
        this.status = "DISPONIVEL"; // Todo item começa disponivel
    }

    // getters e setters
    public String getTitulo() { return titulo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getEditora() { return editora; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(LocalDate data) { this.dataDevolucaoPrevista = data; }
    
    public void adicionarAoHistorico(String registro) { this.historico.add(registro); }
    public List<String> getHistorico() { return historico; }
}